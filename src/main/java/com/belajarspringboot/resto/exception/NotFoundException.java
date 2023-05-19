package com.belajarspringboot.resto.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String pesan){
        super(pesan);
    }
}
