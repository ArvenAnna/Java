/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.repository;

import anna.deliveryservice.domain.Order;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alex
 */
@Repository
public class InMemOrderRepository implements OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    @Override
    public Order save(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public Order findById(int id) {
        for(Order order:orders){
            if(id == order.getId()){
                return order;
            }
        }
        return null;
    }

    @Override
    public Order update(Order order) {
        for(Order ord:orders){
            if(order.getId() == ord.getId()){
                orders.remove(ord);
                break;
            }
        }
        orders.add(order);
        return order;
    }

}
