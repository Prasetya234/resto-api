package com.belajarspringboot.resto.respository;

import com.belajarspringboot.resto.model.Bayar;
import com.belajarspringboot.resto.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface CartRespository extends JpaRepository<Cart, Integer> {
    }

