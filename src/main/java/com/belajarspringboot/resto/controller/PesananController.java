package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.dto.Pesanandto;
import com.belajarspringboot.resto.model.Pesanan;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.PesananService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pesanan")
public class PesananController {
    @Autowired
    private PesananService pesananService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/{userId}")
    public CommonResponse<Pesanan> tambah(@PathVariable("userId") int userId, @RequestBody Pesanandto pesanandto){
        return CommonResponseGenerator.sukses(pesananService.tambah(userId,modelMapper.map(pesanandto, Pesanan.class)));
    }
    @GetMapping("/{no}")
    public CommonResponse<Pesanandto> cari(@PathVariable("no") int no){
        Pesanan pesanan = pesananService.cari(no);
        Pesanandto data = modelMapper.map(pesanan, Pesanandto.class);
        return CommonResponseGenerator.sukses(data);
    }

    @GetMapping("/param")
    public CommonResponse<?> param(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "user", required = false) String user ){
        String[] hasil = {String.valueOf(id), user};
        return CommonResponseGenerator.sukses(hasil);
    }
    @GetMapping("")
    public CommonResponse<List<Pesanan>> tampil(){
        return CommonResponseGenerator.sukses(pesananService.tampil());
    }
   

    @DeleteMapping("/{no}")
    private CommonResponse<Map<String, Boolean>> hapus(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(pesananService.hapus(no));
    }

    @PutMapping("/{no}")
    public CommonResponse<Pesanan> update(@PathVariable("no") int no, @RequestBody Pesanan pesanan){
        return CommonResponseGenerator.sukses(pesananService.update(no, pesanan));
    }
}
