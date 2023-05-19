package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.exception.NotFoundException;
import com.belajarspringboot.resto.model.Meja;
import com.belajarspringboot.resto.respository.MejaRespository;
import com.belajarspringboot.resto.service.MejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MejaServiceImpl implements MejaService {
    @Autowired
    private MejaRespository mejaRespository;

    @Override
    public Meja tambah(Meja meja){return mejaRespository.save(meja);}

    @Override
    public Meja cari(int no){
        return mejaRespository.findById(no).orElseThrow(() -> new NotFoundException("Meja no " + no + "Gak ono" ));
    }

    @Override
    public List<Meja> tampil(){
        return mejaRespository.findAll();
    }

    @Override
    public Map<String, Boolean> hapus (int no){
        Meja hapus = mejaRespository.findById(no).get();
        mejaRespository.delete(hapus);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }

    @Override
    public Meja update(int no, Meja meja) {
        Meja update = mejaRespository.findById(no).get();
        update.setNama(meja.getNama());

        return mejaRespository.save(update);
    }
}
