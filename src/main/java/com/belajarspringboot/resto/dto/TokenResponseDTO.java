package com.belajarspringboot.resto.dto;

import com.belajarspringboot.resto.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TokenResponseDTO {

    private String token;
    //  2002-12-09 16:20:00
    @JsonFormat(pattern = "yyyy-MMM-dd HH:mm:ss")
    private Date exiredDate;
    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExiredDate() {
        return exiredDate;
    }

    public void setExiredDate(Date exiredDate) {
        this.exiredDate = exiredDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
