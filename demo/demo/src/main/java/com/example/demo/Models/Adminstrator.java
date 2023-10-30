package com.example.demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Adminstrator extends User{
    @Column(nullable = false)
    private Boolean isAdmin;
    @Column(nullable = false)
    private Office office;

}