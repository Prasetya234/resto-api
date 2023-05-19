package com.belajarspringboot.resto.model;

import com.belajarspringboot.resto.audit.Audit;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="pesanan")
public class Pesanan extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    @Column(name = "nota", columnDefinition = "varchar(10)")
    private String nota;



    @Column(name = "tgl", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp tgl;


    @Column(name = "no_meja", columnDefinition = "int")
    private int no_meja;

    @Column(name = "waiter", columnDefinition = "varchar(20)")
    private String waiter;

    @Column(name = "user", columnDefinition = "varchar(10)")
    private String user;

    //@Column(name = "dibuat", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
   // private Timestamp dibuat;


    public Pesanan() {
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

    public Timestamp getTgl() {
        return tgl;
    }

    public void setTgl(Timestamp tgl) {
        this.tgl = tgl;
    }

    public int getNo_meja() {
        return no_meja;
    }

    public void setNo_meja(int no_meja) {
        this.no_meja = no_meja;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


}