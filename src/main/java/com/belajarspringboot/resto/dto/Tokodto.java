package com.belajarspringboot.resto.dto;

import javax.persistence.Column;
import java.util.Date;

public class Tokodto {

    private String gbr;


    private String nama;


    private String alamat;


    private String telp;


    private Date buka;


    private Date tutup;

    public String getGbr() {
        return gbr;
    }

    public void setGbr(String gbr) {
        this.gbr = gbr;
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
