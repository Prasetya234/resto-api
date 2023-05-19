package com.belajarspringboot.resto.controller;


import com.belajarspringboot.resto.model.User;
import com.belajarspringboot.resto.respository.UserRespository;
import com.belajarspringboot.resto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User tambah(@RequestBody User user){
        return userService.tambah(user);
    }
    @GetMapping("/{no}")
    public User cari(@PathVariable("no") int no){
        return userService.cari(no);
    }

    @GetMapping("")
    public List<User> tampil(){
        return userService.tampil();
    }

    @DeleteMapping("/{no}")
    private Map<String, Boolean> hapus(@PathVariable("no") int no){
        return userService.hapus(no);
    }

    @PutMapping("/{no}")
    public User update(@PathVariable("no") int no, @RequestBody User user){
        return userService.update(no, user);
    }

}
