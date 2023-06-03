package com.belajarspringboot.resto.service;

import com.belajarspringboot.resto.dto.Ulasandto;
import com.belajarspringboot.resto.model.Ulasan;

import java.util.List;
import java.util.Map;

public interface UlasanService {
    Ulasan tambah(Ulasandto ulasan);

    Ulasan cari(int no);

    List<Ulasan> tampil();

    Map<String, Boolean> hapus(int no);

    Ulasan update(int no, Ulasan ulasan);
}
