/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.domain;

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
    
    public Order() {
    }

    public Order(List<Pizza> pizzas, Customer customer) {
        this.pizzas = pizzas;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", pizzas=" + pizzas + ", customer=" + customer + '}';
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

    public Order(Integer id, List<Pizza> pizzas, Customer customer, Status status) {
        this.id = id;
        this.pizzas = pizzas;
        this.customer = customer;
        this.status = status;
    }
    
    public enum Status {
        NEW, IN_PROGRSS, CANCELED, DONE
    }
    
}
