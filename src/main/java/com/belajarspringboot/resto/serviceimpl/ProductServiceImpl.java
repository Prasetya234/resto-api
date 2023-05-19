package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.exception.NotFoundException;
import com.belajarspringboot.resto.model.Product;
import com.belajarspringboot.resto.respository.ProductRespository;
import com.belajarspringboot.resto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRespository productRespository;

    @Override
    public Product tambah(Product product){return productRespository.save(product);}

    @Override
    public Product cari(int no){
        return productRespository.findById(no).orElseThrow(() -> new NotFoundException("Product no " + no + "Gak ono" ));
    }

    @Override
    public List<Product> tampil(String nama){
        return productRespository.findAllByNamaContainingIgnoreCaseAndTersediaIsTrue(nama);
    }

    @Override
    public Map<String, Boolean> hapus (int no){
        Product hapus = productRespository.findById(no).get();
        productRespository.delete(hapus);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }

    @Override
    public Product update(int no, Product product) {
        Product update = productRespository.findById(no).get();
        update.setNama(product.getNama());
        update.setHarga(product.getHarga());
        return productRespository.save(update);
    }
}
