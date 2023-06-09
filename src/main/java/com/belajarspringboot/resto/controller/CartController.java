package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.dto.AddcartreqDTO;
import com.belajarspringboot.resto.model.Cart;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public CommonResponse<Cart> addCart(@RequestBody AddcartreqDTO addcartreqDTO){
        return CommonResponseGenerator.sukses(cartService.tambah(addcartreqDTO));
    }

    @GetMapping("/{no_user}")
    public CommonResponse<List<Cart>> findAll(@PathVariable("no_user") int no_user){
        return CommonResponseGenerator.sukses(cartService.findAllByUserId(no_user));
    }
}
