package com.belajarspringboot.resto.model;

import com.belajarspringboot.resto.audit.Audit;

import javax.persistence.*;

@Entity
@Table(name="ulasan")
public class Ulasan extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(name = "ulasan", columnDefinition = "text")
    private String ulasan;

    public Ulasan() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getUlasan() {
        return ulasan;
    }

    public void setUlasan(String ulasan) {
        this.ulasan = ulasan;
    }
}
