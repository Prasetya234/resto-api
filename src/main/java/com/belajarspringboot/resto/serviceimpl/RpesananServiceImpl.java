package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.exception.NotFoundException;
import com.belajarspringboot.resto.model.Rpesanan;
import com.belajarspringboot.resto.respository.RpesananRespository;
import com.belajarspringboot.resto.service.RpesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RpesananServiceImpl implements RpesananService {
    @Autowired
    private RpesananRespository rpesananRespository;

    @Override
    public Rpesanan tambah(Rpesanan rpesanan){return rpesananRespository.save(rpesanan);}

    @Override
    public Rpesanan cari(int no){
        return rpesananRespository.findById(no).orElseThrow(() -> new NotFoundException("Rpesanan no " + no + "Gak ono" ));
    }

    @Override
    public List<Rpesanan> tampil(){
        return rpesananRespository.findAll();
    }

    @Override
    public Map<String, Boolean> hapus (int no){
        Rpesanan hapus = rpesananRespository.findById(no).get();
        rpesananRespository.delete(hapus);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }

    @Override
    public Rpesanan update(int no, Rpesanan rpesanan) {
        Rpesanan update = rpesananRespository.findById(no).get();
        update.setKode(rpesanan.getKode());
        update.setHarga(rpesanan.getHarga());
        update.setQty(rpesanan.getQty());
        return rpesananRespository.save(update);
    }
}
