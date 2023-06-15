package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.dto.LoginDto;
import com.belajarspringboot.resto.dto.TokenResponseDTO;
import com.belajarspringboot.resto.dto.User1dto;
import com.belajarspringboot.resto.dto.Userdto;
import com.belajarspringboot.resto.model.User;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping("/register")
    public CommonResponse<User> tambah(@RequestBody Userdto userdto){
        User data = userService.tambah(modelMapper.map(userdto,User.class));
        return CommonResponseGenerator.sukses(data);
    }

    @PostMapping("/login")
    public CommonResponse<TokenResponseDTO> login(@RequestBody LoginDto loginDto) {
        return CommonResponseGenerator.sukses(userService.login(loginDto));
    }
}
