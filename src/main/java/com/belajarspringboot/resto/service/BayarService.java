package com.belajarspringboot.resto.service;

import com.belajarspringboot.resto.model.Bayar;

import java.util.List;
import java.util.Map;

public interface BayarService {
    Bayar tambah(Bayar bayar);

    Bayar cari(int no);

    List<Bayar> tampil();

    Map<String, Boolean> hapus(int no);

    Bayar update(int no, Bayar bayar);
}
