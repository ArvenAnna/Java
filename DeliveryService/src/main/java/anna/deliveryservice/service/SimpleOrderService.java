/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.service;

import anna.deliveryservice.annotation.BanchMark;
import anna.deliveryservice.domain.Customer;
import anna.deliveryservice.domain.Order;
import anna.deliveryservice.domain.Pizza;
import anna.deliveryservice.exception.NoSuchOrderException;
import anna.deliveryservice.exception.TooManyPizzasException;
import anna.deliveryservice.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class SimpleOrderService implements OrderService {

    private static int orderCount = 0;

    private OrderRepository orderRepository;
    private PizzaService pizzaService;
    private CustomerService customerService;
    private final int MAX_PIZZAS_IN_ORDER = 10;

    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.customerService = customerService;
    }

    @Override
    @BanchMark
    public Order placeNewOrder(Customer customer, int... pizzaID) {

        if (pizzaID.length > MAX_PIZZAS_IN_ORDER) {
            throw createTooManyPizzaException();
        }
        orderCount++;
        List<Pizza> pizzas = new ArrayList<Pizza>();

        for (Integer id : pizzaID) {
            pizzas.add(getPizzaById(id));
        }

        Order newOrder = new Order(orderCount, pizzas, customer, Order.Status.NEW);
        saveOrder(newOrder);
        return newOrder;
    }

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
        if ((pizzaID.length + order.getPizzas().size()) > MAX_PIZZAS_IN_ORDER) {
            throw createTooManyPizzaException();
        }

        List<Pizza> pizzas = new ArrayList<Pizza>();

        pizzas.addAll(order.getPizzas());
        for (Integer id : pizzaID) {
            pizzas.add(getPizzaById(id));
        }

        Order newOrder = new Order(order.getId(), pizzas, order.getCustomer(), Order.Status.IN_PROGRSS);

        return orderRepository.update(newOrder);
    }

    @Override
    public Integer getOrderCost(Order order) {
        Integer sum = 0;
        for (Pizza pizza : order.getPizzas()) {
            sum += pizza.getPrice();
        }
        return setCardRate(setRate(sum, order), order);
    }
    
    @Override
    public void payForOrder(Order order){
        Integer sum = getOrderCost(order);
        order.setStatus(Order.Status.DONE);
        orderRepository.update(order);
        if(order.getCustomer().getCard()!=null){
            customerService.addSumToCard(order.getCustomer(), sum);
        }
         
    }
    
    private Integer setCardRate(int cost, Order order){
        int resultCost = cost;
        Integer cardSum = order.getCustomer().getCard();
        if(cardSum!=null){
            int cardRate = cardSum*10/100;
            if(cardRate>cost*30/100){
                cardRate = cost*30/100;
            }  
            resultCost = resultCost - cardRate;
        }
        return resultCost;
    }

    private Integer setRate(int cost, Order order) {
        int resultCost = cost;
        if (order.getPizzas().size() > 4) {
            int max = 0;
            for (Pizza pizza : order.getPizzas()) {
                if(max < pizza.getPrice()){
                    max = pizza.getPrice();
                }
            }   
            resultCost = resultCost-max;
            resultCost = resultCost + (max*30/100);
        }
        return resultCost;
    }

    private Pizza getPizzaById(Integer id) {
        return pizzaService.find(id);
    }

    private TooManyPizzasException createTooManyPizzaException() {
        return new TooManyPizzasException() {
            @Override
            public String getMessage() {
                return "Order can't has more then " + MAX_PIZZAS_IN_ORDER + " pizzas";
            }
        };
    }

    public void init() {
    }
}
