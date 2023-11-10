package com.example.demo.Advice;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dtos.ErrorDto;

@RestControllerAdvice
public class HandlerAdvice {
    
    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity notFound(){
        return new ResponseEntity<>("Objeto não encontrado >:)", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDto> badRequest(MethodArgumentNotValidException exception){
        List<ErrorDto> error = exception.getFieldErrors().stream().map(e-> new ErrorDto(e)).toList();

        return new ResponseEntity<ErrorDto>(error , HttpStatus.BAD_REQUEST);

    }
}
