package com.belajarspringboot.resto.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="toko")
public class Toko {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    @Column(name = "gbr", columnDefinition = "text")
    private String gbr;

    @Column(name = "nama", columnDefinition = "varchar(50)")
    private String nama;

    @Column(name = "alamat", columnDefinition = "text")
    private String alamat;

    @Column(name = "telp", columnDefinition = "varchar(15)")
    private String telp;

    @Column(name = "buka", columnDefinition = "time")
    private Date buka;

    @Column(name = "tutup", columnDefinition = "time")
    private Date tutup;



    public Toko() {
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getGbr() {
        return gbr;
    }

    public void setGbr(String gbr) {
        this.gbr = gbr;
    }
    public Date getBuka() {
        return buka;
    }

    public void setBuka(Date buka) {
        this.buka = buka;
    }
    public Date getTutup() {
        return tutup;
    }

    public void setTutup(Date tutup) {
        this.tutup = tutup;
    }

}
