package com.belajarspringboot.resto.service;

import com.belajarspringboot.resto.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Product tambah(Product product);


    Product cari(int no);

    //List<Product> tampil();

    List<Product> tampil(String name);

    Map<String, Boolean> hapus(int no);

    Product update(int no, Product product);
}
