/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.domain;

import anna.deliveryservice.domain.rate.Rate;
import anna.deliveryservice.exception.TooManyPizzasException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alex
 */
@Component
public class Order {

    private Integer id;
    private List<Pizza> pizzas;
    private Customer customer;
    private Status status;
    private final int MAX_PIZZAS_IN_ORDER = 10;
    @Autowired
    private List<Rate> rates;

    public Order() {
    }

    public Order(List<Pizza> pizzas, Customer customer) {
        checkForTooManyPizzasException(pizzas.size());
        this.pizzas = pizzas;
        this.customer = customer;
    }

    public Order(Integer id, List<Pizza> pizzas, Customer customer, Status status) {
        checkForTooManyPizzasException(pizzas.size());
        this.id = id;
        this.pizzas = pizzas;
        this.customer = customer;
        this.status = status;
    }
    
    public void addMorePizzaz(List<Pizza> morePizzas){
        checkForTooManyPizzasException((pizzas.size()+ morePizzas.size()));
        pizzas.addAll(morePizzas);
    }

    public Integer getpureCost() {
        Integer sum = 0;
        for (Pizza pizza : pizzas) {
            sum += pizza.getPrice();
        }
        return sum;
    }
    
    public Integer getRateCost() {
        Integer cost = getpureCost();
        if(rates != null){
            for(Rate rate:rates){
                cost = cost - rate.addRate(this);
            }
        }
        return cost;
    }

    private void checkForTooManyPizzasException(Integer pizzaCount) {
        if (pizzaCount > MAX_PIZZAS_IN_ORDER) {
            throw new TooManyPizzasException() {
                @Override
                public String getMessage() {
                    return "Order can't has more then " + MAX_PIZZAS_IN_ORDER + " pizzas";
                }
            };
        }
    }

    public Integer getId() {
        return id;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;     
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        checkForTooManyPizzasException(pizzas.size());
        this.pizzas = pizzas;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        NEW, IN_PROGRSS, CANCELED, DONE
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", pizzas=" + pizzas + ", customer=" + 
                customer + ", status=" + status + ", MAX_PIZZAS_IN_ORDER=" + 
                MAX_PIZZAS_IN_ORDER + ", rates=" + rates + '}';
    }

    
}
