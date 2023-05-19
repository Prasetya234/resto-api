package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.model.Rpesanan;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.RpesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rpesanan")
public class RpesananController {
    @Autowired
    private RpesananService rpesananService;

    @PostMapping
    public CommonResponse<Rpesanan> tambah(@RequestBody Rpesanan rpesanan){
        return CommonResponseGenerator.sukses(rpesananService.tambah(rpesanan));
    }
    @GetMapping("/{no}")
    public CommonResponse<Rpesanan> cari(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(rpesananService.cari(no));
    }
    @GetMapping("")
    public CommonResponse<List<Rpesanan>> tampil(){
        return CommonResponseGenerator.sukses(rpesananService.tampil());
    }

    @DeleteMapping("/{no}")
    private CommonResponse<Map<String, Boolean>> hapus(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(rpesananService.hapus(no));
    }

    @PutMapping("/{no}")
    public CommonResponse<Rpesanan> update(@PathVariable("no") int no, @RequestBody Rpesanan rpesanan){
        return CommonResponseGenerator.sukses(rpesananService.update(no, rpesanan));
    }
}
