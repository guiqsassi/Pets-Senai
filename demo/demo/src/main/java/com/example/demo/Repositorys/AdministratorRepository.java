package com.example.demo.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Adminstrator;

public interface AdministratorRepository extends JpaRepository<Adminstrator, Long> {
    
}
