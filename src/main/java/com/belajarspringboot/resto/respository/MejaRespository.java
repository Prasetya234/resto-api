package com.belajarspringboot.resto.respository;

import com.belajarspringboot.resto.model.Meja;
import com.belajarspringboot.resto.model.Ulasan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MejaRespository extends JpaRepository<Meja, Integer> {
}
