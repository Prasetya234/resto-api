package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.dto.Tokodto;
import com.belajarspringboot.resto.model.Toko;
import com.belajarspringboot.resto.model.Toko;
import com.belajarspringboot.resto.model.Toko;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.TokoService;
import com.belajarspringboot.resto.service.TokoService;
import com.belajarspringboot.resto.service.TokoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/toko")
public class TokoController {
    @Autowired
    private TokoService tokoService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public CommonResponse<Toko> tambah(@RequestBody Tokodto tokodto){
        return CommonResponseGenerator.sukses(tokoService.tambah(modelMapper.map(tokodto, Toko.class)));
    }
    @GetMapping("/{no}")
    public CommonResponse<Tokodto> cari(@PathVariable("no") int no){
        Toko toko = tokoService.cari(no);
        Tokodto data = modelMapper.map(toko, Tokodto.class);
        return CommonResponseGenerator.sukses(data);
    }

    @GetMapping("/param")
    public CommonResponse<?> param(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "user", required = false) String user ){
        String[] hasil = {String.valueOf(id), user};
        return CommonResponseGenerator.sukses(hasil);
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
