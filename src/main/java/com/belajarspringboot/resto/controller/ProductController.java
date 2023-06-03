package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.dto.ProductResponseDTO;
import com.belajarspringboot.resto.dto.Productdto;
import com.belajarspringboot.resto.model.Product;

import com.belajarspringboot.resto.model.User;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public CommonResponse<Product> tambah(@RequestBody Productdto productdto){
        Product data = productService.tambah(modelMapper.map(productdto, Product.class));
        return CommonResponseGenerator.sukses(data);
    }
    @GetMapping("/{no}")
    public CommonResponse<Productdto> cari(@PathVariable("no") int no){
        Product product = productService.cari(no);
        Productdto data = modelMapper.map(product, Productdto.class);
        return CommonResponseGenerator.sukses(data);
    }

    @GetMapping("/param")
    public CommonResponse<?> param(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "user", required = false) String user ){
        String[] hasil = {String.valueOf(id), user};
        return CommonResponseGenerator.sukses(hasil);
    }
    @GetMapping("")
    public CommonResponse<List<ProductResponseDTO>> tampil(@RequestParam(name = "nama", required = false, defaultValue = "") String name){

        List<ProductResponseDTO> data = productService.tampil(name).stream().map(v -> modelMapper.map(v, ProductResponseDTO.class)).collect(Collectors.toList());
        return CommonResponseGenerator.sukses(data);
    }

    @DeleteMapping("/{no}")
    private CommonResponse<Map<String, Boolean>> hapus(@PathVariable("no") int no){
        return CommonResponseGenerator.sukses(productService.hapus(no));
    }

    @PutMapping("/{no}")
    public CommonResponse<Product> update(@PathVariable("no") int no, @RequestBody Product product){
        return CommonResponseGenerator.sukses(productService.update(no, product));
    }


}
