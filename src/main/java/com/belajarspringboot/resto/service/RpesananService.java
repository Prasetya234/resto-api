package com.belajarspringboot.resto.service;

import com.belajarspringboot.resto.model.Rpesanan;

import java.util.List;
import java.util.Map;

public interface RpesananService {
    Rpesanan tambah(Rpesanan rpesanan);

    Rpesanan cari(int no);

    List<Rpesanan> tampil();

    Map<String, Boolean> hapus(int no);

    Rpesanan update(int no, Rpesanan rpesanan);
}
