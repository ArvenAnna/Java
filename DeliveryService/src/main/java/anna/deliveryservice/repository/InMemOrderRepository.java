/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.repository;

import anna.deliveryservice.domain.Order;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class InMemOrderRepository implements OrderRepository{
private final List<Order> orders = new ArrayList<>();
    @Override
    public Order save(Order order) {
        orders.add(order);
        return order;
    }
    
}
