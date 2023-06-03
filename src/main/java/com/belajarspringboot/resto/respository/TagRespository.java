package com.belajarspringboot.resto.respository;

import com.belajarspringboot.resto.model.Product;
import com.belajarspringboot.resto.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRespository extends JpaRepository<Tag, Integer> {
}
