package com.belajarspringboot.resto.respository;

import com.belajarspringboot.resto.enumated.EnumStatusPesanan;
import com.belajarspringboot.resto.model.Cart;
import com.belajarspringboot.resto.model.Pesanan;
import com.belajarspringboot.resto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PesananRespository extends JpaRepository<Pesanan, Integer> {
    List<Pesanan> findAllByUser (User user);

    List<Pesanan> findAllByStatusPesanan (EnumStatusPesanan enumStatusPesanan);
}
