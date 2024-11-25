package com.cosconcosplay.coscon.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalerrorcontroller {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> resposta(Exception ex){
return ResponseEntity.badRequest().body("Erro: " + ex.getCause());
    }
}