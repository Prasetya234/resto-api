package com.belajarspringboot.resto.dto;

import javax.persistence.Column;

public class Bayardto {
    private String nota;
    private int harga;

    private int disc;

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
}
