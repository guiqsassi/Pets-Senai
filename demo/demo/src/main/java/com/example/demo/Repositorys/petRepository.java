package com.example.demo.Repositorys;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Pet;


public interface petRepository extends JpaRepository<Pet, Long> {

    public List<Pet> findByName(String name);


   
}
