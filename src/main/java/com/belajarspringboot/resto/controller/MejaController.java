package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.model.Meja;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.MejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/meja")
public class MejaController {
    @Autowired
    private MejaService mejaService;

    @PostMapping
    public CommonResponse<Meja> tambah(@RequestBody Meja meja){
        return CommonResponseGenerator.sukses(mejaService.tambah(meja));
    }
    @GetMapping("/{no}")
    public CommonResponse<Meja> cari(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(mejaService.cari(no));
    }
    @GetMapping("")
    public CommonResponse<List<Meja>> tampil(){
        return CommonResponseGenerator.sukses(mejaService.tampil());
    }

    @DeleteMapping("/{no}")
    private CommonResponse<Map<String, Boolean>> hapus(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(mejaService.hapus(no));
    }

    @PutMapping("/{no}")
    public CommonResponse<Meja> update(@PathVariable("no") int no, @RequestBody Meja meja){
        return CommonResponseGenerator.sukses(mejaService.update(no, meja));
    }
}
