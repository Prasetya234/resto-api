package com.belajarspringboot.resto.respository;

import com.belajarspringboot.resto.model.Pesanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesananRespository extends JpaRepository<Pesanan, Integer> {
}
