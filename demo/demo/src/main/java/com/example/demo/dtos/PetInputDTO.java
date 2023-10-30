package com.example.demo.dtos;

import com.example.demo.Models.Status;

public record PetInputDTO(
    String name,
    Status status
) 
{}
