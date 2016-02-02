/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.repository;

import anna.deliveryservice.domain.Pizza;
import java.util.Map;
import javax.annotation.PostConstruct;

/**
 *
 * @author Alex
 */

public class InMemPizzaRepository implements PizzaRepository{
    
    private Map<Integer, Pizza> pizzas;

    
    public void setPizzas(Map<Integer, Pizza> pizzas) {
        this.pizzas = pizzas;
    } 

    @Override
    public Pizza find(Integer id) {
        return pizzas.get(id);
    }
    
    @PostConstruct
    public void init(){
    }
}
