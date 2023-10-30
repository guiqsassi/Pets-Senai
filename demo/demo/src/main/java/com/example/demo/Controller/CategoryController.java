package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Category;
import com.example.demo.Services.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping
@RestController("/Categories")
public class CategoryController {
    @Autowired
    private CategoryService service;


    @PostMapping(value="/Categorys")
    public ResponseEntity<Category> post(@RequestBody Category category) {
        Category categoriaCriada = service.create(category);
        
        ResponseEntity<Category> resposta = new ResponseEntity<Category>(categoriaCriada, null);
        
        return resposta;
    }
    
    @PutMapping("/update")
    public ResponseEntity<Category> put(@RequestBody Category category){
        Category categoriaCriada = service.update(category);
                
        return ResponseEntity.ok(categoriaCriada);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> read(@PathVariable long id){
        Category categoryBuscada = service.read(id);
        return ResponseEntity.ok(categoryBuscada);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Category>> list(){
        List<Category> categories = service.list();
        return ResponseEntity.ok(categories);
    }

    
}