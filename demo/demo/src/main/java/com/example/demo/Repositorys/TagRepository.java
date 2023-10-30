package com.example.demo.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Tag;

public interface TagRepository extends JpaRepository<Tag,Long> {
    
}
