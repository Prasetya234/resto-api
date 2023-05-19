package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.model.Wallet;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @PostMapping
    public CommonResponse<Wallet> tambah(@RequestBody Wallet wallet){
        return CommonResponseGenerator.sukses(walletService.tambah(wallet));
    }
    @GetMapping("/{no}")
    public CommonResponse<Wallet> cari(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(walletService.cari(no));
    }
    @GetMapping("")
    public CommonResponse<List<Wallet>> tampil(){
        return CommonResponseGenerator.sukses(walletService.tampil());
    }

    @DeleteMapping("/{no}")
    private CommonResponse<Map<String, Boolean>> hapus(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(walletService.hapus(no));
    }

    @PutMapping("/{no}")
    public CommonResponse<Wallet> update(@PathVariable("no") int no, @RequestBody Wallet wallet){
        return CommonResponseGenerator.sukses(walletService.update(no, wallet));
    }
}
