package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.dto.Rpesanandto;
import com.belajarspringboot.resto.model.Rpesanan;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.RpesananService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rpesanan")
public class RpesananController {
    @Autowired
    private RpesananService rpesananService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public CommonResponse<Rpesanan> tambah(@RequestBody Rpesanandto rpesanandto){
        return CommonResponseGenerator.sukses(rpesananService.tambah(modelMapper.map(rpesanandto, Rpesanan.class)));
    }
    @GetMapping("/{no}")
    public CommonResponse<Rpesanandto> cari(@PathVariable("no") int no){
        Rpesanan rpesanan = rpesananService.cari(no);
        Rpesanandto data = modelMapper.map(rpesanan, Rpesanandto.class);
        return CommonResponseGenerator.sukses(data);
    }

    @GetMapping("/param")
    public CommonResponse<?> param(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "user", required = false) String user ){
        String[] hasil = {String.valueOf(id), user};
        return CommonResponseGenerator.sukses(hasil);
    }
    

    @DeleteMapping("/{no}")
    private CommonResponse<Map<String, Boolean>> hapus(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(rpesananService.hapus(no));
    }

    @PutMapping("/{no}")
    public CommonResponse<Rpesanan> update(@PathVariable("no") int no, @RequestBody Rpesanan rpesanan){
        return CommonResponseGenerator.sukses(rpesananService.update(no, rpesanan));
    }

    @GetMapping("")
    public CommonResponse<List<Rpesanan>> tampil(){
        return CommonResponseGenerator.sukses(rpesananService.tampil());
    }
}
