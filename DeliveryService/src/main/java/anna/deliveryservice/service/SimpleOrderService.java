/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.service;

import anna.deliveryservice.domain.Customer;
import anna.deliveryservice.domain.Order;
import anna.deliveryservice.domain.Pizza;
import anna.deliveryservice.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class SimpleOrderService implements OrderService {
    
    private static int orderCount = 0;

    private OrderRepository orderRepository;
    private PizzaService pizzaService;
    
    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService){
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;   
    }
    
    @Override
    public Order placeNewOrder(Customer customer, int ... pizzaID){
        orderCount++;
        List<Pizza> pizzas = new ArrayList<Pizza>();
        
        for(Integer id: pizzaID){
            pizzas.add(getPizzaById(id));
        }

        Order newOrder = new Order(orderCount, pizzas, customer);
        saveOrder(newOrder);
        return newOrder;
    }
    
    public void saveOrder(Order order){
        orderRepository.save(order);
    }
    
    private Pizza getPizzaById(Integer id){  
        return pizzaService.find(id);
    }
    
    public void init(){
        
    }
}
