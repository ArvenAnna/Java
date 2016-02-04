/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.service;

import anna.deliveryservice.annotation.BanchMark;
import anna.deliveryservice.domain.Pizza;
import anna.deliveryservice.repository.PizzaRepository;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex
 */
@Service
public class SimplePizzaService implements PizzaService{
    
    private PizzaRepository pizzaRepository;
    
    @Autowired
    public SimplePizzaService(PizzaRepository pizzaRepository){
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    @BanchMark
    public Pizza find(Integer id) {
        return pizzaRepository.find(id);
    } 
    
    @PostConstruct
    public void init(){
        System.out.println("I'm postconstruct");
    }
}