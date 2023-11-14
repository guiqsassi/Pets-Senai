package com.example.demo.dtos;

import org.springframework.validation.FieldError;

public record ErrorDto(
    String fied,
    String error
) {
    public ErrorDto(FieldError exception){
        this(exception.getField(), exception.getDefaultMessage());
    }
}
