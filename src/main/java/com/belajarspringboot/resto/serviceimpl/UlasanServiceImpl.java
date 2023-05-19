package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.exception.NotFoundException;
import com.belajarspringboot.resto.model.Ulasan;
import com.belajarspringboot.resto.respository.UlasanRespository;
import com.belajarspringboot.resto.service.UlasanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UlasanServiceImpl implements UlasanService {
    @Autowired
    private UlasanRespository ulasanRespository;

    @Override
    public Ulasan tambah(Ulasan ulasan){return ulasanRespository.save(ulasan);}

    @Override
    public Ulasan cari(int no){
        return ulasanRespository.findById(no).orElseThrow(() -> new NotFoundException("Ulasan no " + no + "Gak ono" ));
    }

    @Override
    public List<Ulasan> tampil(){
        return ulasanRespository.findAll();
    }

    @Override
    public Map<String, Boolean> hapus (int no){
        Ulasan hapus = ulasanRespository.findById(no).get();
        ulasanRespository.delete(hapus);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }

    @Override
    public Ulasan update(int no, Ulasan ulasan) {
        Ulasan update = ulasanRespository.findById(no).get();
        update.setUlasan(ulasan.getUlasan());
        return ulasanRespository.save(update);
    }
}
