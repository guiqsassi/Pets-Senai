package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Category;
import com.example.demo.Repositorys.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional
    public Category create( Category category){
         Category categoryCriada = repository.save(category);
         return categoryCriada;
    }

    @Transactional
    public Category update(Category category){
        if(repository.existsById(category.getId())){
        Category categoryAtualizada = repository.save(category);
        return categoryAtualizada;    
        }
        else{
            return null;
        }
        
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
    public List<Category> list(){
        List<Category> categorys = repository.findAll();
        return categorys;
    }
    public Category read(Long id){
        if(repository.existsById(id)){
            return repository.findById(id).get();
        }
        else{
            return null;
        }
    }


}
