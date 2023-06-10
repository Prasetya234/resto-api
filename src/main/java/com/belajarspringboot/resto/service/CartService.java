package com.belajarspringboot.resto.service;

import com.belajarspringboot.resto.dto.AddcartreqDTO;
import com.belajarspringboot.resto.model.Cart;

import java.util.List;

public interface CartService {
    Cart tambah(AddcartreqDTO addcartreqDTO);

    Cart removeCartItem(int noCart, int noCartItem);

    List<Cart> findAllByUserId(int userNo);
}
