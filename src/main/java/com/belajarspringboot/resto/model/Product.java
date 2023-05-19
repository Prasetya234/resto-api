package com.belajarspringboot.resto.model;

import com.belajarspringboot.resto.audit.Audit;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(name = "nama", columnDefinition = "varchar(50)")
    private String nama;

    @Column(name = "gbr", columnDefinition = "text")
    private String gbr;
    @Column(name = "ket", columnDefinition = "text")
    private String ket;
    @Column(name = "harga", columnDefinition = "float")
    private float harga;

    @Column(name = "tersedia", columnDefinition = "tinyint(1)")
    private Boolean tersedia;

    public Product(){

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGbr() {
        return gbr;
    }

    public void setGbr(String gbr) {
        this.gbr = gbr;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public Boolean getTersedia() {
        return tersedia;
    }

    public void setTersedia(Boolean tersedia) {
        this.tersedia = tersedia;
    }
}
