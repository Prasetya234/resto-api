package com.belajarspringboot.resto.respository;

import com.belajarspringboot.resto.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {
    List<Product> findAllByNamaContainingIgnoreCaseAndTersediaIsTrue(String nama);
}
