package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.dto.Walletdto;
import com.belajarspringboot.resto.model.Wallet;
import com.belajarspringboot.resto.model.Wallet;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.WalletService;
import com.belajarspringboot.resto.service.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public CommonResponse<Wallet> tambah(@RequestBody Walletdto walletdto) {
        return CommonResponseGenerator.sukses(walletService.tambah(modelMapper.map(walletdto, Wallet.class)));
    }

    @GetMapping("/{no}")
    public CommonResponse<Walletdto> cari(@PathVariable("no") int no) {
        Wallet wallet = walletService.cari(no);
        Walletdto data = modelMapper.map(wallet, Walletdto.class);
        return CommonResponseGenerator.sukses(data);
    }

    @GetMapping("/param")
    public CommonResponse<?> param(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "user", required = false) String user) {
        String[] hasil = {String.valueOf(id), user};
        return CommonResponseGenerator.sukses(hasil);
    }

    @GetMapping("")
    public CommonResponse<List<Wallet>> tampil() {
        return CommonResponseGenerator.sukses(walletService.tampil());
    }


    @DeleteMapping("/{no}")
    private CommonResponse<Map<String, Boolean>> hapus(@PathVariable("no") int no) {
        return CommonResponseGenerator.sukses(walletService.hapus(no));
    }

    @PutMapping("/{no}")
    public CommonResponse<Wallet> update(@PathVariable("no") int no, @RequestBody Wallet wallet) {
        return CommonResponseGenerator.sukses(walletService.update(no, wallet));
    }
}
