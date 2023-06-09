package com.belajarspringboot.resto.respository;

import com.belajarspringboot.resto.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRespository extends JpaRepository<CartItem, Integer> {
}
