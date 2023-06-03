package com.belajarspringboot.resto.model;

import javax.persistence.*;

@Entity
@Table(name="meja")
public class Meja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(name = "nama", columnDefinition = "varchar(20)")
    private String nama;

    public Meja() {
    }
    @ManyToOne
    @JoinColumn(name = "no_toko")
    private Toko toko;
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

    public Toko getToko() {
        return toko;
    }

    public void setToko(Toko toko) {
        this.toko = toko;
    }
}
