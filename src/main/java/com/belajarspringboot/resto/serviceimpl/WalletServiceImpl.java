package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.exception.NotFoundException;
import com.belajarspringboot.resto.model.Wallet;
import com.belajarspringboot.resto.respository.WalletRespository;
import com.belajarspringboot.resto.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletRespository walletRespository;

    @Override
    public Wallet tambah(Wallet wallet){return walletRespository.save(wallet);}

    @Override
    public Wallet cari(int no){
        return walletRespository.findById(no).orElseThrow(() -> new NotFoundException("Wallet no " + no + "Gak ono" ));
    }

    @Override
    public List<Wallet> tampil(){
        return walletRespository.findAll();
    }

    @Override
    public Map<String, Boolean> hapus (int no){
        Wallet hapus = walletRespository.findById(no).get();
        walletRespository.delete(hapus);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }

    @Override
    public Wallet update(int no, Wallet wallet) {
        Wallet update = walletRespository.findById(no).get();

        update.setSaldo(wallet.getSaldo());
        return walletRespository.save(update);
    }
}
