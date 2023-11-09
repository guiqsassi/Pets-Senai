package com.example.demo.dtos;

import com.example.demo.Models.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetInputDTO(
    @NotBlank
    String name,
    @NotNull
    Status status
) 
{}
