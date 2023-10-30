package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Models.Order;
import com.example.demo.Repositorys.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;


    @Transactional
    public Order create( Order order){
        Order orderCriado = repository.save(order);
        return orderCriado;
    }

    @Transactional
    public Order update(Order order){
        if(repository.existsById(order.getId())){
        Order orderAtualizado = repository.save(order);
        return orderAtualizado;
    }
    else{
        return null;
    }
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
    public List<Order> list(){
        List<Order> orders = repository.findAll();
        return orders;
    }
    public Order read(Long id){
        if(repository.existsById(id)){
            return repository.findById(id).get();
        }
        else{
            return null;
        }
        }   
}
