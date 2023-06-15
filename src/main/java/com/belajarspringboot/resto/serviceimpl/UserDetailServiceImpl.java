package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.exception.NotFoundException;
import com.belajarspringboot.resto.model.User;
import com.belajarspringboot.resto.model.UserPrinciple;
import com.belajarspringboot.resto.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRespository userRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRespository.findByEmail(username).orElseThrow(() -> new NotFoundException("Email Not Found"));
        return UserPrinciple.build(user);
    }
}
