package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Pet;
import com.example.demo.Services.PetService;
import com.example.demo.dtos.PetInputDTO;
import com.example.demo.dtos.PetOutputDto;

import jakarta.validation.Valid;


@RestController

@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;
    
    @PostMapping
    public ResponseEntity<PetOutputDto> createPet(@RequestBody @Valid PetInputDTO pet ){

        PetOutputDto petCriado = service.create(pet);

        ResponseEntity<PetOutputDto> resposta = new ResponseEntity<>(petCriado, HttpStatus.CREATED);
        return resposta;
    }
    @PostMapping("/findByName")
    public ResponseEntity<List<PetOutputDto>> list(@RequestParam String name ){

        List<PetOutputDto> petCriado = service.list(name);

        ResponseEntity<List<PetOutputDto>> resposta = new ResponseEntity<>(petCriado, HttpStatus.CREATED);
        return resposta;
    }
    // @GetMapping
    // public ResponseEntity<List<PetOutputDto>> getAll(Pageable page){

    //     List<PetOutputDto> pets = service.list(page);
    //     ResponseEntity<List<PetOutputDto>> resposta = new ResponseEntity<>(pets, HttpStatus.OK);
    //     return resposta;
    // }
    @PutMapping
    public ResponseEntity<Pet> updatePet(@RequestBody Pet pet){

        service.update(pet);

        return ResponseEntity.ok(pet);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Pet> deletePet(@PathVariable Long id){

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<PetOutputDto> read(@PathVariable Long id){

        PetOutputDto petCriado = service.read(id);

        return new ResponseEntity<PetOutputDto>(petCriado, HttpStatus.OK);
    }

}
