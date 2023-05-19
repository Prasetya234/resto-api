package com.belajarspringboot.resto.respository;

import com.belajarspringboot.resto.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRespository extends JpaRepository<Wallet, Integer> {
}
