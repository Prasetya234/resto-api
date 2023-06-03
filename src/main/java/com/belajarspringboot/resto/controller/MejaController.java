package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.dto.Mejadto;
import com.belajarspringboot.resto.model.Meja;

import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.MejaService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/meja")
public class MejaController {
    @Autowired
    private MejaService mejaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public CommonResponse<Meja> tambah(@RequestBody Mejadto mejadto){
        return CommonResponseGenerator.sukses(mejaService.tambah(modelMapper.map(mejadto, Meja.class)));
    }
    @GetMapping("/{no}")
    public CommonResponse<Mejadto> cari(@PathVariable("no") int no){
        Meja meja = mejaService.cari(no);
        Mejadto data = modelMapper.map(meja, Mejadto.class);
        return CommonResponseGenerator.sukses(data);
    }

    @GetMapping("/param")
    public CommonResponse<?> param(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "user", required = false) String user ){
        String[] hasil = {String.valueOf(id), user};
        return CommonResponseGenerator.sukses(hasil);
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
