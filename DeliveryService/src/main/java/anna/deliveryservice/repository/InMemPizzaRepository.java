/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.repository;

import anna.deliveryservice.domain.Pizza;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alex
 */
public class InMemPizzaRepository implements PizzaRepository{
    private static final Map<Integer, Pizza> pizzas = new HashMap<>();
    {
        pizzas.put(1, new Pizza(1,"Sea", Pizza.PizzaType.Meat, 25));
        pizzas.put(2, new Pizza(2,"Sea", Pizza.PizzaType.Sea, 40));
        pizzas.put(3, new Pizza(3,"Sea", Pizza.PizzaType.Vegetarian, 30));
    }
    @Override
    public Pizza find(Integer id) {
        return pizzas.get(id);
    }
    
}
