/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.domain;

/**
 *
 * @author Alex
 */
public class Pizza {

    private Integer id;
    private String name;
    private PizzaType pizzaType;
    private Integer price;

    public Pizza() {
    }

    public Pizza(Integer id, String name, PizzaType pizzaType, Integer price) {
        this.id = id;
        this.name = name;
        this.pizzaType = pizzaType;
        this.price = price;
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
