package com.belajarspringboot.resto.model;

import com.belajarspringboot.resto.audit.Audit;
import com.belajarspringboot.resto.enumated.EnumRole;
import com.belajarspringboot.resto.enumated.EnumStatusPesanan;
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







    @Column(name = "no_meja", columnDefinition = "int")
    private int no_meja;

    @Enumerated(EnumType.STRING)
    @Column(name ="status_pesanan")
    private EnumStatusPesanan statusPesanan ;
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




    public int getNo_meja() {
        return no_meja;
    }

    public void setNo_meja(int no_meja) {
        this.no_meja = no_meja;
    }

    public EnumStatusPesanan getStatusPesanan() {
        return statusPesanan;
    }

    public void setStatusPesanan(EnumStatusPesanan statusPesanan) {
        this.statusPesanan = statusPesanan;
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