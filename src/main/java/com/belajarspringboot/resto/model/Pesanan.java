package com.belajarspringboot.resto.model;

import com.belajarspringboot.resto.audit.Audit;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pesanan")
public class Pesanan extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    @Column(name = "nota", columnDefinition = "varchar(10)")
    private String nota;



    @Column(name = "tgl", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp tgl;


    @Column(name = "no_meja", columnDefinition = "int")
    private int no_meja;

    @Column(name = "waiter", columnDefinition = "varchar(20)")
    private String waiter;
    @Column(name="is_apply")
    private boolean isApply;


    @ManyToOne
    @JoinColumn(name = "no_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "no_toko")
    private Toko toko;

    @ManyToOne
    @JoinColumn(name = "no_cart")
    private Cart cart;






    public Pesanan() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Timestamp getTgl() {
        return tgl;
    }

    public void setTgl(Timestamp tgl) {
        this.tgl = tgl;
    }

    public int getNo_meja() {
        return no_meja;
    }

    public void setNo_meja(int no_meja) {
        this.no_meja = no_meja;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isApply() {
        return isApply;
    }

    public void setApply(boolean apply) {
        isApply = apply;
    }


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Toko getToko() {
        return toko;
    }

    public void setToko(Toko toko) {
        this.toko = toko;
    }


}