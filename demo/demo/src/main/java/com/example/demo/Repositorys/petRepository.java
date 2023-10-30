package com.example.demo.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Pet;

public interface petRepository extends JpaRepository<Pet, Long> {
    
   
}
