package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.exception.NotFoundException;
import com.belajarspringboot.resto.model.Bayar;
import com.belajarspringboot.resto.respository.BayarRespository;
import com.belajarspringboot.resto.service.BayarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BayarServiceImpl implements BayarService {
    @Autowired
    private BayarRespository bayarRespository;

    @Override
    public Bayar tambah(Bayar bayar){return bayarRespository.save(bayar);}

    @Override
    public Bayar cari(int no){
        return bayarRespository.findById(no).orElseThrow(() -> new NotFoundException("Bayar no " + no + "Gak ono" ));
    }

    @Override
    public List<Bayar> tampil(){
        return bayarRespository.findAll();
    }

    @Override
    public Map<String, Boolean> hapus (int no){
        Bayar hapus = bayarRespository.findById(no).get();
        bayarRespository.delete(hapus);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }

    @Override
    public Bayar update(int no, Bayar bayar) {
        Bayar update = bayarRespository.findById(no).get();
        update.setHarga(bayar.getHarga());
        update.setDisc(bayar.getDisc());
        return bayarRespository.save(update);
    }
}
