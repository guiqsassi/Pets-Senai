package com.example.demo.Advice;

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
        ErrorDto error = new ErrorDto(exception);

        return new ResponseEntity<ErrorDto>(error , HttpStatus.BAD_REQUEST);

    }
}
