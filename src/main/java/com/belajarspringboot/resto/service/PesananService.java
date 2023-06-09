package com.belajarspringboot.resto.service;

import com.belajarspringboot.resto.dto.Pesanandto;
import com.belajarspringboot.resto.enumated.EnumStatusPesanan;
import com.belajarspringboot.resto.model.Pesanan;

import java.util.List;
import java.util.Map;

public interface PesananService {


    Pesanan tambah(Pesanandto pesanandto);

    List<Pesanan> findAllByUserId(int userNo);

    List<Pesanan> findAllByPesanan(EnumStatusPesanan enumStatusPesanan);

    Pesanan cari(int no);

    List<Pesanan> tampil();

    Map<String, Boolean> hapus(int no);

    Pesanan update(int no, Pesanan pesanan);



    Pesanan update_status(int pesananId);
}
