package com.belajarspringboot.resto.service;

import com.belajarspringboot.resto.model.Wallet;

import java.util.List;
import java.util.Map;

public interface WalletService {
    Wallet tambah(Wallet wallet);

    Wallet cari(int no);

    List<Wallet> tampil();

    Map<String, Boolean> hapus(int no);

    Wallet update(int no, Wallet wallet);
}
