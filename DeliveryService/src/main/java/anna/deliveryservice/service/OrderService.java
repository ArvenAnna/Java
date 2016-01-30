/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.service;

import anna.deliveryservice.domain.Customer;
import anna.deliveryservice.domain.Order;

/**
 *
 * @author Alex
 */
public interface OrderService {

    Order placeNewOrder(Customer customer, int... pizzaID);

    void saveOrder(Order order);
    
    Order addPizzasToOrder(int orderId, int... pizzaID);
    
    void payForOrder(Order order);
}
