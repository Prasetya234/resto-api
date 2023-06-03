package com.belajarspringboot.resto.model;

import com.belajarspringboot.resto.audit.Audit;

import javax.persistence.*;

@Entity
@Table(name="wallet")
public class Wallet extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    //@Column(name = "username", columnDefinition = "varchar(20)")
    //private String username;
    @Column(name = "saldo", columnDefinition = "int")
    private int saldo;

    @ManyToOne
    @JoinColumn(name = "no_user")
    private User user;

    public Wallet() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
