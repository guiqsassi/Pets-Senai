package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Pet;
import com.example.demo.Services.PetService;
import com.example.demo.dtos.PetInputDTO;
import com.example.demo.dtos.PetOutputDto;


@RestController

@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;
    
    @PostMapping("/postPet")
    public ResponseEntity<Pet> createPet(@RequestBody PetInputDTO pet ){

        Pet petCriado = service.create(pet);

        ResponseEntity<Pet> resposta = new ResponseEntity<>(petCriado, HttpStatus.CREATED);
        return resposta;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Pet>> getAll(){

        List<Pet> pets = service.list();
        ResponseEntity<List<Pet>> resposta = new ResponseEntity<>(pets, HttpStatus.OK);
        return resposta;
    }
    @PostMapping("/updatePet")
    public ResponseEntity<Pet> updatePet(@RequestBody Pet pet){

        service.update(pet);

        return ResponseEntity.ok(pet);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Pet> deletePet(@PathVariable Long id){

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
