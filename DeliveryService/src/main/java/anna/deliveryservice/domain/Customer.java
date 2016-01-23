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

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + '}';
    }

    public Customer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    private Integer id;
    private String name;
        
}
