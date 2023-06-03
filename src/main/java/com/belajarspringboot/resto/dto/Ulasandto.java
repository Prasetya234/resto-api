package com.belajarspringboot.resto.dto;

public class Ulasandto {
    private String ulasan;
    private int no_user;
    private int no_product;
    public String getUlasan() {
        return ulasan;
    }

    public void setUlasan(String ulasan) {
        this.ulasan = ulasan;
    }

    public int getNo_user() {
        return no_user;
    }

    public void setNo_user(int no_user) {
        this.no_user = no_user;
    }

    public int getNo_product() {
        return no_product;
    }

    public void setNo_product(int no_product) {
        this.no_product = no_product;
    }
}
