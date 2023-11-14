package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Models.User;
import com.example.demo.Repositorys.userRepository;


@Service
public class UserServices implements UserDetailsService {
    @Autowired
    private userRepository repository;

    @Transactional
    public User create( User user){
        String password = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(password);
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
    public User findByEmail(String email){
        User user = repository.findByEmail(email);
        return user;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails user = repository.findByEmail(email);
        if(user == null){

            throw new UsernameNotFoundException("User with email: " + email + " not found");
        }
        return  org.springframework.security.core.userdetails.User.builder()
        .username(user.getUsername())
        .password(user.getPassword())
        .build();   
       


        }
}
