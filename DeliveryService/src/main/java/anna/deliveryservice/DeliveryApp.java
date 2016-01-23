package anna.deliveryservice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import anna.deliveryservice.domain.Order;
import anna.deliveryservice.domain.Customer;
import anna.deliveryservice.service.SimpleOrderService;

/**
 *
 * @author Alex
 */
public class DeliveryApp {
    public static void main(String[] args){
        Customer customer = new Customer(1, "Vasya");
        Order order;
        SimpleOrderService orderService = new SimpleOrderService();
        order = orderService.placeNewOrder(customer, 1,2,3);
        System.out.println(order);
    }
}
