package com.example.demo.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.User;
import java.util.List;
import java.util.Optional;


public interface userRepository extends JpaRepository<User, Long>{
    public Optional<User> findByEmail(String email);
}   
