package anna.deliveryservice;

import anna.deliveryservice.domain.Customer;
import anna.deliveryservice.domain.Order;
import anna.deliveryservice.domain.Pizza;
import anna.deliveryservice.listener.AddingPizzasEvent;
//import anna.deliveryservice.repository.InMemPizzaRepository;
import anna.deliveryservice.repository.PizzaRepository;
import anna.deliveryservice.service.OrderService;
import anna.deliveryservice.service.SimpleOrderService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Alex
 */
public class SpringDeliveryApp {
    public static void main(String[] args) throws Exception{
        
//        ConfigurableApplicationContext repositoryContext = 
//                new ClassPathXmlApplicationContext(new String[]{ 
//            "repositoryContext.xml"});
//        
//        ConfigurableApplicationContext appContext = 
//                new ClassPathXmlApplicationContext(new String[]{"appContext.xml"}, repositoryContext);
//        
//        
//        System.out.println("Beans in context --------");
//        for(String name: appContext.getBeanDefinitionNames()){
//            System.out.println(name);
//        }
//        System.out.println("Beans in context --------");
//        
//        ApplicationContext parent = appContext.getParent();
//        System.out.println(parent);
//        
//        Customer c = appContext.getBean(Customer.class);
//  
//        
//        OrderService orderService = appContext.getBean(OrderService.class);
//        Order order = orderService.placeNewOrder(c, 1,1,1,1,1);
//        
//        System.out.println(order);
//        System.out.println(order.getRateCost());
//        
//        List<Pizza> addPizzas = new ArrayList<Pizza>();
//        PizzaRepository prep = (PizzaRepository)appContext.getBean("pizzaRepo");
//        addPizzas.add(prep.find(2));
//        order.addMorePizzaz(addPizzas);
//        System.out.println(order);
//        appContext.publishEvent(new AddingPizzasEvent(appContext,"pizzas were added"));
//        
//        
//        System.out.println(appContext.getBean("newCustomer"));
// 
//        repositoryContext.close();
//        appContext.close();
    }
}