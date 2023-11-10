package com.example.demo.dtos;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public record ErrorDto(
    String fied,
    String error
) {
    public ErrorDto(FieldError exception){
        this(exception.getField(), exception.getDefaultMessage());
    }
}
