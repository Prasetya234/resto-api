package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.dto.AddcartreqDTO;
import com.belajarspringboot.resto.model.Cart;
import com.belajarspringboot.resto.respository.CartRespository;
import com.belajarspringboot.resto.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

public class CartServiceImpl implements CartService {
    @Autowired
    private CartRespository cartRespository;

    @Override
    public Cart tambah(AddcartreqDTO addcartreqDTO){
        return null;
    }
}
