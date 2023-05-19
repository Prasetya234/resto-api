package com.belajarspringboot.resto.service;

import com.belajarspringboot.resto.model.Toko;

import java.util.List;
import java.util.Map;

public interface TokoService {
    Toko tambah(Toko toko);

    Toko cari(int no);

    List<Toko> tampil();

    Map<String, Boolean> hapus(int no);

    Toko update(int no, Toko toko);
}
