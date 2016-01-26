package anna.deliveryservice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import anna.deliveryservice.domain.Order;
import anna.deliveryservice.domain.Customer;
import anna.deliveryservice.infrastructure.ApplicationContext;
import anna.deliveryservice.infrastructure.JavaConfig;
import anna.deliveryservice.infrastructure.JavaConfigApplicationContext;
import anna.deliveryservice.service.OrderService;

/**
 *
 * @author Alex
 */
public class DeliveryApp {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new JavaConfigApplicationContext(new JavaConfig());
        Customer customer = new Customer(1, "Vasya");
        Order order;
        OrderService orderService = (OrderService)context.getBean("orderService");
        order = orderService.placeNewOrder(customer, 1,2,3);
        System.out.println(order);
    }
}
