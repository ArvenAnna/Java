/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.repository;

import anna.deliveryservice.domain.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class InMemCustomerRepository implements CustomerRepository{

    private final List<Customer> customers = new ArrayList<Customer>();
    
    @Override
    public Customer findById(int id) {
        for(Customer customer:customers){
            if(id == customer.getId()){
                return customer;
            }
        }
        return null;
    }
    
    @Override
    public Customer update(Customer customer) {
        for(Customer cust:customers){
            if(customer.getId().equals(cust.getId())){
                customers.remove(cust);
                break;
            }
        }
        customers.add(customer);
        return customer;
    }
    
    public void init(){
       customers.add(new Customer(1,"Vasiliy"));
       customers.add(new Customer(2,"dddd"));
    }
    
}
