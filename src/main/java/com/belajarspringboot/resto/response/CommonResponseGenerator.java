package com.belajarspringboot.resto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonResponseGenerator {
    public static <T> CommonResponse<T> sukses(T data){
        CommonResponse<T> response = new CommonResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setPesan(HttpStatus.OK.name());
        response.setData(data);
        return response;
    }

    public static <T> ResponseEntity<?> gagal (T pesan, HttpStatus http){
        CommonResponse<T> response = new CommonResponse();
        response.setStatus(http.value());
        response.setPesan(http.name());
        response.setData(pesan);
        return new ResponseEntity<>(response, http);
    }
}
