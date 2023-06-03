package com.belajarspringboot.resto.dto;

import javax.persistence.Column;

public class Walletdto {
    private int no_user;
    private int saldo;

    public int getNo_user() {
        return no_user;
    }

    public void setNo_user(int no_user) {
        this.no_user = no_user;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
