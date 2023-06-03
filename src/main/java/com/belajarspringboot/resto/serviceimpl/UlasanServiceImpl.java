package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.dto.Ulasandto;
import com.belajarspringboot.resto.exception.NotFoundException;
import com.belajarspringboot.resto.model.Product;
import com.belajarspringboot.resto.model.Ulasan;
import com.belajarspringboot.resto.model.User;
import com.belajarspringboot.resto.model.Wallet;
import com.belajarspringboot.resto.respository.ProductRespository;
import com.belajarspringboot.resto.respository.UlasanRespository;
import com.belajarspringboot.resto.respository.UserRespository;
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
    @Autowired
    private UserRespository userRespository;
    @Autowired
    private ProductRespository productRespository;

    @Override
    public Ulasan tambah(Ulasandto ulasan){
        int no_user = ulasan.getNo_user();
        int no_product = ulasan.getNo_product();
        User user = userRespository.findById(no_user).orElseThrow(() -> new NotFoundException("User no " + no_user + "Gak ono" ));
        var product = productRespository.findById(no_product).orElseThrow(() -> new NotFoundException("Product no " + no_product + "Gak ono" ));
        //Ulasan ulasan1 = ulasanRespository.save(ulasan);
        //Product product = new Product();
        Ulasan ulasan1 = new Ulasan();
        ulasan1.setUlasan(ulasan.getUlasan());
        ulasan1.setUser(user);
        ulasan1.setProduct(product);
       // ulasan.setUser(ulasan1);
       // ulasan.setProduct(ulasan1);
       // ulasanRespository.save();
        //return user1;
        return ulasanRespository.save(ulasan1);
    }

    @Override
    public Ulasan cari(int no){
        return ulasanRespository.findById(no).orElseThrow(() -> new NotFoundException("Ulasan no " + no + " Gak ono" ));
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
