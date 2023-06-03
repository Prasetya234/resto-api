package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.dto.Bayardto;
import com.belajarspringboot.resto.model.Bayar;
import com.belajarspringboot.resto.model.Bayar;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.BayarService;
import com.belajarspringboot.resto.service.BayarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bayar")
public class BayarController {
    @Autowired
    private BayarService bayarService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public CommonResponse<Bayar> tambah(@RequestBody Bayardto bayardto){
        return CommonResponseGenerator.sukses(bayarService.tambah(modelMapper.map(bayardto, Bayar.class)));
    }
    @GetMapping("/{no}")
    public CommonResponse<Bayardto> cari(@PathVariable("no") int no){
        Bayar bayar = bayarService.cari(no);
        Bayardto data = modelMapper.map(bayar, Bayardto.class);
        return CommonResponseGenerator.sukses(data);
    }

    @GetMapping("/param")
    public CommonResponse<?> param(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "user", required = false) String user ){
        String[] hasil = {String.valueOf(id), user};
        return CommonResponseGenerator.sukses(hasil);
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
