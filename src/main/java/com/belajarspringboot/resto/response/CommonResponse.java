package com.belajarspringboot.resto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonResponse <T>{
    @JsonProperty("status")
    private int status;
    @JsonProperty("pesan")
    private String pesan;
    @JsonProperty("data")
    private T data;

    public CommonResponse() {
    }

    public CommonResponse(int status, String pesan, T data) {
        this.status = status;
        this.pesan = pesan;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
