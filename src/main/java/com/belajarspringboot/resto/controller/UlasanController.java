package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.dto.Ulasandto;
import com.belajarspringboot.resto.model.Ulasan;
import com.belajarspringboot.resto.model.Ulasan;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.UlasanService;
import com.belajarspringboot.resto.service.UlasanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/ulasan")
public class UlasanController {
    @Autowired
    private UlasanService ulasanService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public CommonResponse<Ulasan> tambah(@RequestBody Ulasandto ulasandto){
        return CommonResponseGenerator.sukses(ulasanService.tambah(ulasandto));
    }
    @GetMapping("/{no}")
    public CommonResponse<Ulasandto> cari(@PathVariable("no") int no){
        Ulasan ulasan = ulasanService.cari(no);
        Ulasandto data = modelMapper.map(ulasan, Ulasandto.class);
        return CommonResponseGenerator.sukses(data);
    }

    @GetMapping("/param")
    public CommonResponse<?> param(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "user", required = false) String user ){
        String[] hasil = {String.valueOf(id), user};
        return CommonResponseGenerator.sukses(hasil);
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
