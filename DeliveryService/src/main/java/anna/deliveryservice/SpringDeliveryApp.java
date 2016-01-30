/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice;

import anna.deliveryservice.domain.Customer;
import anna.deliveryservice.domain.Order;
import anna.deliveryservice.repository.PizzaRepository;
import anna.deliveryservice.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Alex
 */
public class SpringDeliveryApp {
    public static void main(String[] args) throws Exception{
        
        ConfigurableApplicationContext repositoryContext = 
                new ClassPathXmlApplicationContext(new String[]{ 
            "repositoryContext.xml"});
        
        ConfigurableApplicationContext appContext = 
                new ClassPathXmlApplicationContext(new String[]{"appContext.xml"}, repositoryContext);
        
        
        
        ApplicationContext parent = appContext.getParent();
        System.out.println(parent);
        
        Customer c = appContext.getBean("customer", Customer.class);
        Customer c1 = appContext.getBean("newCustomer", Customer.class);
        Customer c2 = appContext.getBean("newCustomer", Customer.class);
        System.out.println(c1);
        System.out.println(c2);
        
        OrderService orderService = (OrderService)appContext.getBean("orderServ");
        Order order = orderService.placeNewOrder(c, 1);
        System.out.println(order);
        //PizzaRepository pizzaRepository = (PizzaRepository)appContext.getBean("pizzaRepo");
        //System.out.println(pizzaRepository.find(1));
        repositoryContext.close();
        appContext.close();
    }
}