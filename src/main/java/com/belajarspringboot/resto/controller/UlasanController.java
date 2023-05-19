package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.model.Ulasan;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.UlasanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public class UlasanController {
    @Autowired
    private UlasanService ulasanService;

    @PostMapping
    public CommonResponse<Ulasan> tambah(@RequestBody Ulasan ulasan){
        return CommonResponseGenerator.sukses(ulasanService.tambah(ulasan));
    }
    @GetMapping("/{no}")
    public CommonResponse<Ulasan> cari(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(ulasanService.cari(no));
    }
    @GetMapping("")
    public CommonResponse<List<Ulasan>> tampil(){
        return CommonResponseGenerator.sukses(ulasanService.tampil());
    }

    @DeleteMapping("/{no}")
    private CommonResponse<Map<String, Boolean>> hapus(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(ulasanService.hapus(no));
    }

    @PutMapping("/{no}")
    public CommonResponse<Ulasan> update(@PathVariable("no") int no, @RequestBody Ulasan ulasan){
        return CommonResponseGenerator.sukses(ulasanService.update(no, ulasan));
    }
}
