package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.dto.Pesanandto;
import com.belajarspringboot.resto.enumated.EnumStatusPesanan;
import com.belajarspringboot.resto.model.Pesanan;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.PesananService;
import com.belajarspringboot.resto.serviceimpl.PesananServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pesanan")
public class PesananController {
    @Autowired
    private PesananServiceImpl pesananService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("")
    public CommonResponse<Pesanan> tambah(@RequestBody Pesanandto pesanandto){
        return CommonResponseGenerator.sukses(pesananService.tambah(pesanandto));
    }

    @GetMapping("/{no}")
    public CommonResponse<Pesanandto> cari(@PathVariable("no") int no){
        Pesanan pesanan = pesananService.cari(no);
        Pesanandto data = modelMapper.map(pesanan, Pesanandto.class);
        return CommonResponseGenerator.sukses(data);
    }

    @GetMapping("/param")
    public CommonResponse<?> param(@RequestParam(name = "status_pesanan", required = false) EnumStatusPesanan status){

        return CommonResponseGenerator.sukses(pesananService.findAllByPesanan(status));
    }
    @GetMapping("/{userid}")
    public CommonResponse<List<Pesanan>> tampil(@PathVariable("userid") int userid){
        return CommonResponseGenerator.sukses(pesananService.findAllByUserId(userid));
    }



    @DeleteMapping("/{no}")
    private CommonResponse<Map<String, Boolean>> hapus(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(pesananService.hapus(no));
    }

    @PutMapping("/{no}")
    public CommonResponse<Pesanan> update(@PathVariable("no") int no, @RequestBody Pesanan pesanan){
        return CommonResponseGenerator.sukses(pesananService.update(no, pesanan));
    }

    @PutMapping("/confirm/{pesananid}")
    public CommonResponse<Pesanan> pesananId(@PathVariable("pesananid") int pesananId){
        return CommonResponseGenerator.sukses(pesananService.update_status(pesananId));
    }


}
