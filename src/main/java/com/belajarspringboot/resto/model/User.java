package com.belajarspringboot.resto.model;

import com.belajarspringboot.resto.audit.Audit;
import com.belajarspringboot.resto.enumated.EnumRole;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(name = "nama", columnDefinition = "varchar(20)")
    private String nama;

    @Column(name = "email", columnDefinition = "varchar(50)")
    private String email;

    @Column(name = "password", columnDefinition = "varchar(10)")
    private String password;

    @Column(name = "telp", columnDefinition = "varchar(13)")
    private String telp;
    @Enumerated(EnumType.STRING)
    @Column(name ="role")
    private EnumRole role;

    public User() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EnumRole getRole() {
        return role;
    }

    public void setRole(EnumRole role) {
        this.role = role;
    }
}
