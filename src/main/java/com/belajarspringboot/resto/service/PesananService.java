package com.belajarspringboot.resto.service;

import com.belajarspringboot.resto.model.Pesanan;

import java.util.List;
import java.util.Map;

public interface PesananService {


    Pesanan tambah(int userId, Pesanan pesanan);

    Pesanan cari(int no);

    List<Pesanan> tampil();

    Map<String, Boolean> hapus(int no);

    Pesanan update(int no, Pesanan pesanan);
}
