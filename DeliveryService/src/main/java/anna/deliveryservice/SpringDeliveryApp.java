/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice;

import anna.deliveryservice.domain.Customer;
import anna.deliveryservice.domain.Order;
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
        
        for(String name: appContext.getBeanDefinitionNames()){
            System.out.println(name);
        }
        
        ApplicationContext parent = appContext.getParent();
        System.out.println(parent);
        
        Customer c = appContext.getBean(Customer.class);
        
        OrderService orderService = (OrderService)appContext.getBean("orderServ");
        Order order = orderService.placeNewOrder(c, 1,1,1,1,1);
        System.out.println(order);
        
        System.out.println(order.getRateCost());
 
        //PizzaRepository pizzaRepository = (PizzaRepository)appContext.getBean("pizzaRepo");
        //System.out.println(pizzaRepository.find(1));
        repositoryContext.close();
        appContext.close();
    }
}