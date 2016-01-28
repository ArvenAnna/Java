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
public class Customer {
    
    private Integer id;
    private String name;
    private String address;
    private Integer card;
    
    public Customer() {
    }

    public Customer(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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
    

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + '}';
    }     
}
