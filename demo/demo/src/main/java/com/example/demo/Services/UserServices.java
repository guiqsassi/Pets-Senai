package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Models.User;
import com.example.demo.Repositorys.userRepository;


@Service
public class UserServices {
    @Autowired
    private userRepository repository;

    @Transactional
    public User create( User user){
         User userCriado = repository.save(user);
        return userCriado;    
    }   


    @Transactional
    public User update(User user){
        if(repository.existsById(user.getId())){
        User userAtualizado = repository.save(user);
        return userAtualizado;    
        }
        else{
            return null;
        }
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
    public List<User> list(){
        List<User> users = repository.findAll();
        return users;
    }
    public User read(Long id){
        if(repository.existsById(id)){
            return repository.findById(id).get();
        }
        else{
            return null;
        }
    }
    
}
