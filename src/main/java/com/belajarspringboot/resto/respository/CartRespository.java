package com.belajarspringboot.resto.respository;

import com.belajarspringboot.resto.model.Bayar;
import com.belajarspringboot.resto.model.Cart;
import com.belajarspringboot.resto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
    public interface CartRespository extends JpaRepository<Cart, Integer> {
        Optional<Cart> findByUserAndStatusIsFalse(User user);
        List<Cart> findAllByUser (User user);
    }

