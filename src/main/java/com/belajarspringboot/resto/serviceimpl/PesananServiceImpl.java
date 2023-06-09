package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.dto.Pesanandto;
import com.belajarspringboot.resto.enumated.EnumStatusPesanan;
import com.belajarspringboot.resto.exception.NotFoundException;
import com.belajarspringboot.resto.model.*;
import com.belajarspringboot.resto.respository.*;
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
    @Autowired
    private UserRespository userRespository;

    @Autowired
    private CartRespository cartRespository;

    @Autowired
    private MejaRespository mejaRespository;

    @Autowired
    private TokoRespository tokoRespository;


    @Override
    public Pesanan tambah(Pesanandto pesanandto){
        User finduser = userRespository.findById(pesanandto.getNo_user()).orElseThrow(() -> new NotFoundException("User id tidak ditemukan"));
        Cart findcart = cartRespository.findById(pesanandto.getNo_cart()).orElseThrow(()-> new NotFoundException("Cart id tidak ditemukan"));
        Toko findtoko = tokoRespository.findById(pesanandto.getNo_toko()).orElseThrow(()-> new NotFoundException("Toko id tidak ditemukan"));


        findcart.setStatus(true);
        cartRespository.save(findcart);

        Pesanan pesanan = new Pesanan();
        pesanan.setNo_meja(pesanandto.getNo_meja());
        pesanan.setStatusPesanan(EnumStatusPesanan.SEDANG_DIBUAT);
        pesanan.setApply(false);
        pesanan.setUser(finduser);
        pesanan.setCart(findcart);
        pesanan.setToko(findtoko);
        pesanan.setPaid(false);
        return pesananRespository.save(pesanan);
    }

    @Override
    public List<Pesanan> findAllByUserId(int userNo){
        User user = userRespository.findById(userNo).orElseThrow(() -> new NotFoundException("User id tidak ditemukan"));
        return pesananRespository.findAllByUser(user);
    }

    @Override
    public List<Pesanan> findAllByPesanan(EnumStatusPesanan enumStatusPesanan){
        return pesananRespository.findAllByStatusPesanan(enumStatusPesanan);
    }
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

        return pesananRespository.save(update);
    }
    @Override
    public Pesanan update_status(int pesananId){
        Pesanan pesanan = pesananRespository.findById(pesananId).orElseThrow(()-> new NotFoundException("Pesanan id tidak ditemukan"));
        pesanan.setStatusPesanan(EnumStatusPesanan.SELESAI);
        return pesananRespository.save(pesanan);
    }
}
