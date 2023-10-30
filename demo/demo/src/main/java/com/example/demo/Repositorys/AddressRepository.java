package com.example.demo.Repositorys;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {
    
}
