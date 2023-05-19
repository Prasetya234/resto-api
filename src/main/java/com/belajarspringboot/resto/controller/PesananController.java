package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.model.Pesanan;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.PesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pesanan")
public class PesananController {
    @Autowired
    private PesananService pesananService;

    @PostMapping
    public CommonResponse<Pesanan> tambah(@RequestBody Pesanan pesanan){
        return CommonResponseGenerator.sukses(pesananService.tambah(pesanan));
    }
    @GetMapping("/{no}")
    public CommonResponse<Pesanan> cari(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(pesananService.cari(no));
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
