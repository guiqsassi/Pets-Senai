package com.example.demo.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    
}
