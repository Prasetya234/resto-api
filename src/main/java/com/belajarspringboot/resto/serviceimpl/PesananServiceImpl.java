package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.exception.NotFoundException;
import com.belajarspringboot.resto.model.Pesanan;
import com.belajarspringboot.resto.respository.PesananRespository;
import com.belajarspringboot.resto.service.PesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PesananServiceImpl implements PesananService {
    @Autowired
    private PesananRespository pesananRespository;

    @Override
    public Pesanan tambah(Pesanan pesanan){return pesananRespository.save(pesanan);}

    @Override
    public Pesanan cari(int no){
        return pesananRespository.findById(no).orElseThrow(() -> new NotFoundException("Pesanan no " + no + "Gak ono" ));
    }

    @Override
    public List<Pesanan> tampil(){
        return pesananRespository.findAll();
    }

    @Override
    public Map<String, Boolean> hapus (int no){
        Pesanan hapus = pesananRespository.findById(no).get();
        pesananRespository.delete(hapus);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }

    @Override
    public Pesanan update(int no, Pesanan pesanan) {
        Pesanan update = pesananRespository.findById(no).get();
        update.setNo_meja(pesanan.getNo_meja());
        update.setWaiter(pesanan.getWaiter());
        return pesananRespository.save(update);
    }
}
