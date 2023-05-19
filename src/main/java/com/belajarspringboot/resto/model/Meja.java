package com.belajarspringboot.resto.model;

import javax.persistence.*;

@Entity
@Table(name="meja")
public class Meja {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(name = "nama", columnDefinition = "varchar(20)")
    private String nama;

    public Meja() {
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
}
