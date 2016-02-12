/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.service;

import anna.deliveryservice.annotation.BanchMark;
import anna.deliveryservice.domain.Customer;
import anna.deliveryservice.domain.Order;
import anna.deliveryservice.domain.OrderDetail;
import anna.deliveryservice.domain.Pizza;
import anna.deliveryservice.exception.NoSuchOrderException;
import anna.deliveryservice.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex
 */

@Service
public class SimpleOrderService implements OrderService{

    private static int orderCount = 0;

    private OrderRepository orderRepository;
    private PizzaService pizzaService;
    private CustomerService customerService;
    //private ApplicationContext appContext;
    
    private Order order;

    @Autowired
    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.customerService = customerService;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }


    @Override
    @BanchMark
    public Order placeNewOrder(Customer customer, int... pizzaID) {
        orderCount++;
        List<Pizza> pizzas = new ArrayList<Pizza>();

        for (Integer id : pizzaID) {
            pizzas.add(getPizzaById(id));
        }
        Order newOrder = createNewOrder();
        newOrder.setCustomer(customer);
        //OrderDetail details = null;
        //newOrder.setDetails(details);
        newOrder.setId(orderCount);
        newOrder.setStatus(Order.Status.NEW);
        
        saveOrder(newOrder);
        return newOrder;
    }
    
    @Lookup()
    Order createNewOrder(){
        return null;
    }
    
//    abstract Order createNewOrder();
//    {
//        return (Order)appContext.getBean("order");
//    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order addPizzasToOrder(int orderId, int... pizzaID) {
        Order order = orderRepository.findById(orderId);
        if (order == null) {
            throw new NoSuchOrderException();
        }

        List<Pizza> pizzas = new ArrayList<Pizza>();
        for (Integer id : pizzaID) {
            pizzas.add(getPizzaById(id));
        }
        
        order.addMorePizzaz(pizzas);
        order.setStatus(Order.Status.IN_PROGRSS);
        return orderRepository.update(order);
    }
    
    @Override
    public void payForOrder(Order order){
        order.setStatus(Order.Status.DONE);
        orderRepository.update(order);
        if(order.getCustomer().getCard()!=null){
            customerService.addSumToCard(order.getCustomer(), order.getpureCost());
        }     
    }

    private Pizza getPizzaById(Integer id) {
        return pizzaService.find(id);
    }

    public void init() {
    }
}
