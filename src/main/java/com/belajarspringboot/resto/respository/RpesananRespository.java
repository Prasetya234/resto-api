package com.belajarspringboot.resto.respository;

import com.belajarspringboot.resto.model.Rpesanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RpesananRespository extends JpaRepository<Rpesanan, Integer> {
}
