package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Models.Pet;
import com.example.demo.Repositorys.petRepository;
import com.example.demo.dtos.PetInputDTO;
import org.springframework.data.domain.Pageable;
import com.example.demo.dtos.PetOutputDto;

@Service
public class PetService {
    @Autowired
    private petRepository repository;

    @Transactional
    public PetOutputDto create( PetInputDTO dto){
            Pet petAuxiliar = new Pet(dto);
            Pet created = repository.save(petAuxiliar);
            PetOutputDto petResposta = new PetOutputDto(created);
            return petResposta;


    }

    @Transactional
    public Pet update(Pet pet){
        if(repository.existsById(pet.getId())){
        Pet petAtualizado = repository.save(pet);
        return petAtualizado;

        }
        return null;
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<PetOutputDto> list(Pageable page){
        var pets = repository.findAll(page).stream().map(p-> new PetOutputDto(p)).toList();
        return pets;
    }

    public Pet read(Long id){
        if(repository.existsById(id)){
            return repository.findById(id).get();
        }
        else{
            return null;
        }
      

    }
}
