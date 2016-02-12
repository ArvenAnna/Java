/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.domain;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * 
 */

@Entity 
@Table(name = "pizza")
public class Pizza {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false) 
    long id;
    
    @Column(name = "name")
    String name;
    
    @Column(name = "pizzatype")
    @Enumerated(EnumType.STRING)
    PizzaType pizzaType;
    
    @Column(name = "price")
    Integer price;

    public Pizza() {
    }

    public Pizza(Integer id, String name, PizzaType pizzaType, Integer price) {
        this.id = id;
        this.name = name;
        this.pizzaType = pizzaType;
        this.price = price;
    }

    public Pizza(Integer id, String name, PizzaType pizzaType) {
        this.id = id;
        this.name = name;
        this.pizzaType = pizzaType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }
    
    

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    
    
    public enum PizzaType {
        Vegetarian, Sea, Meat
    }

    @Override
    public String toString() {
        return "Pizza{" + "id=" + id + ", name=" + name + ", pizzaType=" + pizzaType + ", price=" + price + '}';
    }
    
}
