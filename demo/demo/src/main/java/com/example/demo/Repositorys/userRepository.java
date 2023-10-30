package com.example.demo.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.User;

public interface userRepository extends JpaRepository<User, Long>{
    
}
