package com.belajarspringboot.resto.model;

import com.belajarspringboot.resto.audit.Audit;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="bayar")
public class Bayar extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(name = "nota", columnDefinition = "varchar(10)")
    private String nota;
    @Column(name = "harga", columnDefinition = "int")
    private int harga;

    @Column(name = "disc", columnDefinition = "int")
    private int disc;

    @ManyToOne
    @JoinColumn(name = "no_user")
    private User user;

    public Bayar() {
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

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getDisc() {
        return disc;
    }

    public void setDisc(int disc) {
        this.disc = disc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}