/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.service;

import anna.deliveryservice.infrastructure.ServiceLocator;
import anna.deliveryservice.domain.Pizza;
import anna.deliveryservice.repository.PizzaRepository;

/**
 *
 * @author Alex
 */
public class SimplePizzaService implements PizzaService{
    
//    private ServiceLocator serviceLocator = ServiceLocator.getInstance();
//    
//    private PizzaRepository pizzaRepository = serviceLocator.createImplementation("pizzaRepository");
//
//    @Override
//    public Pizza find(Integer id) {
//        return pizzaRepository.find(id);
//    }  
    
    //private ServiceLocator serviceLocator = ServiceLocator.getInstance();
    
    private PizzaRepository pizzaRepository;
    
    public SimplePizzaService(PizzaRepository pizzaRepository){
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public Pizza find(Integer id) {
        return pizzaRepository.find(id);
    } 
    
    public void init(){
    }
}
//роберт мартин "Чистый код"
//разница межд иос и ди martinfowler.com/articles/injection.html#ServiceLocatorVsD