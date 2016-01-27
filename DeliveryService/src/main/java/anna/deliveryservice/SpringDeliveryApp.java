/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice;

import anna.deliveryservice.repository.PizzaRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Alex
 */
public class SpringDeliveryApp {
    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
        PizzaRepository pizzaRepository = (PizzaRepository)appContext.getBean("pizzaRepo");
        System.out.println(pizzaRepository.find(1));
    }
}
