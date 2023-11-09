package com.example.demo.dtos;

import org.yaml.snakeyaml.constructor.Construct;

import com.example.demo.Models.Pet;

import  com.example.demo.Models.Status;



public record PetOutputDto(
    long id,
    String name,
    Status status
){
    public PetOutputDto(Pet pet) {
      this(pet.getId(), pet.getName(), pet.getStatus());
    }
}