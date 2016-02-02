/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alex
 */
@Component
public class Customer {
    
    private Integer id;
    private String name;
    private Address address;
    @Value("40")
    private Integer card;
    
    public Customer() {
    }

    public Customer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer(String name) {
        this.name = name;
    }
    
    public void addSumToCard(int sum){
        if(card != null){
            card = card + sum;
        }  
    }

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", address=" + address + ", card=" + card + '}';
    }    
}
