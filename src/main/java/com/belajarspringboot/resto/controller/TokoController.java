package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.model.Toko;
import com.belajarspringboot.resto.model.Toko;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.TokoService;
import com.belajarspringboot.resto.service.TokoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/toko")
public class TokoController {
    @Autowired
    private TokoService tokoService;

    @PostMapping
    public CommonResponse<Toko> tambah(@RequestBody Toko toko){
        return CommonResponseGenerator.sukses(tokoService.tambah(toko));
    }
    @GetMapping("/{no}")
    public CommonResponse<Toko> cari(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(tokoService.cari(no));
    }
    @GetMapping("")
    public CommonResponse<List<Toko>> tampil(){
        return CommonResponseGenerator.sukses(tokoService.tampil());
    }

    @DeleteMapping("/{no}")
    private CommonResponse<Map<String, Boolean>> hapus(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(tokoService.hapus(no));
    }

    @PutMapping("/{no}")
    public CommonResponse<Toko> update(@PathVariable("no") int no, @RequestBody Toko toko){
        return CommonResponseGenerator.sukses(tokoService.update(no, toko));
    }
}
