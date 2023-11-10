package com.example.demo.Repositorys;


import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Pet;
import com.example.demo.dtos.PetOutputDto;


public interface petRepository extends JpaRepository<Pet, Long> {

    public List<Pet> findByName(String name);


   
}
