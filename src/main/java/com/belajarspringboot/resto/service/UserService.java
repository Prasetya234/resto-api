package com.belajarspringboot.resto.service;

import com.belajarspringboot.resto.dto.LoginDto;
import com.belajarspringboot.resto.dto.TokenResponseDTO;
import com.belajarspringboot.resto.model.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface UserService {

    User tambah(User user);
    TokenResponseDTO login(LoginDto loginDto);

    User cari(int no);

    List<User> tampil();

    Map<String, Boolean> hapus(int no);


    User update(int no, User user);
}
