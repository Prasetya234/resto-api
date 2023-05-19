package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.exception.NotFoundException;
import com.belajarspringboot.resto.model.Toko;
import com.belajarspringboot.resto.respository.TokoRespository;
import com.belajarspringboot.resto.service.TokoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class TokoServiceImpl implements TokoService {
    @Autowired
    private TokoRespository tokoRespository;

    @Override
    public Toko tambah(Toko toko){return tokoRespository.save(toko);}

    @Override
    public Toko cari(int no){
        return tokoRespository.findById(no).orElseThrow(() -> new NotFoundException("Toko no " + no + "Gak ono" ));
    }

    @Override
    public List<Toko> tampil(){
        return tokoRespository.findAll();
    }

    @Override
    public Map<String, Boolean> hapus (int no){
        Toko hapus = tokoRespository.findById(no).get();
        tokoRespository.delete(hapus);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }

    @Override
    public Toko update(int no, Toko toko) {
        Toko update = tokoRespository.findById(no).get();
        update.setNama(toko.getNama());
        update.setAlamat(toko.getAlamat());
        update.setTelp(toko.getTelp());
        return tokoRespository.save(update);
    }
}
