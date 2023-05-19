package com.belajarspringboot.resto.model;

import com.belajarspringboot.resto.audit.Audit;

import javax.persistence.*;

@Entity
@Table(name="wallet")
public class Wallet extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(name = "username", columnDefinition = "varchar(20)")
    private String username;
    @Column(name = "saldo", columnDefinition = "int")
    private int saldo;

    public Wallet() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
