package com.belajarspringboot.resto.service;

import com.belajarspringboot.resto.dto.AddcartreqDTO;
import com.belajarspringboot.resto.model.Cart;

public interface CartService {
    Cart tambah(AddcartreqDTO addcartreqDTO);
}
