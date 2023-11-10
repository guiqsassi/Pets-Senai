package com.example.demo.dtos;

import org.springframework.web.bind.MethodArgumentNotValidException;

public record ErrorDto(
    String fied,
    String error
) {
    public ErrorDto(MethodArgumentNotValidException exception){
        this(exception.getFieldError().getField(), exception.getFieldError().getDefaultMessage());
    }
}
