package com.belajarspringboot.resto.service;

import com.belajarspringboot.resto.model.Meja;

import java.util.List;
import java.util.Map;

public interface MejaService {
    Meja tambah(Meja meja);

    Meja cari(int no);

    List<Meja> tampil();

    Map<String, Boolean> hapus(int no);

    Meja update(int no, Meja meja);
}
