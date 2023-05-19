package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.model.User;
import com.belajarspringboot.resto.respository.UserRespository;
import com.belajarspringboot.resto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRespository userRespository;
    @Override
    public User tambah(User user) {
        return userRespository.save(user);
    }

    @Override
    public User cari(int no) {
        return userRespository.findById(no).get();
    }

    @Override
    public List<User> tampil() {
        return userRespository.findAll();
    }


    @Override
    public Map<String, Boolean> hapus(int no) {
        User hapus = userRespository.findById(no).get();
        userRespository.delete(hapus);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }



    @Override
    public User update(int no, User user) {
        User update = userRespository.findById(no).get();
        update.setNama(user.getNama());
        update.setEmail(user.getEmail());
        update.setPassword(user.getPassword());
        return userRespository.save(update);
    }




}
