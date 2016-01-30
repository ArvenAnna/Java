/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.domain;

import anna.deliveryservice.exception.TooManyPizzasException;
import java.util.List;

/**
 *
 * @author Alex
 */
public class Order {

    private Integer id;
    private List<Pizza> pizzas;
    private Customer customer;
    private Status status;
    private final int MAX_PIZZAS_IN_ORDER = 10;

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

    public Integer getCost() {
        Integer sum = 0;
        for (Pizza pizza : pizzas) {
            sum += pizza.getPrice();
        }
        return setCardRate(setRate(sum));
    }

    private Integer setCardRate(int cost) {
        int resultCost = cost;
        Integer cardSum = customer.getCard();
        if (cardSum != null) {
            int cardRate = cardSum * 10 / 100;
            if (cardRate > cost * 30 / 100) {
                cardRate = cost * 30 / 100;
            }
            resultCost = resultCost - cardRate;
        }
        return resultCost;
    }

    private Integer setRate(int cost) {
        int resultCost = cost;
        if (pizzas.size() > 4) {
            int max = 0;
            for (Pizza pizza : pizzas) {
                if (max < pizza.getPrice()) {
                    max = pizza.getPrice();
                }
            }
            resultCost = resultCost - max;
            resultCost = resultCost + (max * 30 / 100);
        }
        return resultCost;
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
        return "Order{" + "id=" + id + ", pizzas=" + pizzas + ", customer=" + customer + '}';
    }
}
