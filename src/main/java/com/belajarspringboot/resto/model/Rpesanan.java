package com.belajarspringboot.resto.model;

import javax.persistence.*;

@Entity
@Table(name="rpesanan")
public class Rpesanan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(name = "nota", columnDefinition = "varchar(10)")
    private String nota;
    @Column(name = "kode", columnDefinition = "varchar(10)")
    private String kode;

    @Column(name = "qty", columnDefinition = "int")
    private int qty;

    @Column(name = "harga", columnDefinition = "int")
    private int harga;

    @Column(name = "catatan", columnDefinition = "varchar(255)")
    private String catatan;

    public Rpesanan() {
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

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}
