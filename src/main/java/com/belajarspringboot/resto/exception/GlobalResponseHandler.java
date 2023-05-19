package com.belajarspringboot.resto.exception;

import com.belajarspringboot.resto.response.CommonResponseGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalResponseHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException (NotFoundException notFoundException){
        return CommonResponseGenerator.gagal(notFoundException.getMessage(),HttpStatus.NOT_FOUND);
    }
}
