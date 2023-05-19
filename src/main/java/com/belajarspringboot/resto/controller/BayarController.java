package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.model.Bayar;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.BayarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bayar")
public class BayarController {
    @Autowired
    private BayarService bayarService;

    @PostMapping
    public CommonResponse<Bayar> tambah(@RequestBody Bayar bayar){
        return CommonResponseGenerator.sukses(bayarService.tambah(bayar));
    }
    @GetMapping("/{no}")
    public CommonResponse<Bayar> cari(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(bayarService.cari(no));
    }
    @GetMapping("")
    public CommonResponse<List<Bayar>> tampil(){
        return CommonResponseGenerator.sukses(bayarService.tampil());
    }

    @DeleteMapping("/{no}")
    private CommonResponse<Map<String, Boolean>> hapus(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(bayarService.hapus(no));
    }

    @PutMapping("/{no}")
    public CommonResponse<Bayar> update(@PathVariable("no") int no, @RequestBody Bayar bayar){
        return CommonResponseGenerator.sukses(bayarService.update(no, bayar));
    }
}
