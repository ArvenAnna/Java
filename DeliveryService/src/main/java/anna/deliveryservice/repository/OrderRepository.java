/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.repository;

import anna.deliveryservice.domain.Order;

/**
 *
 * @author Alex
 */
public interface OrderRepository {
    Order save(Order order);
}
