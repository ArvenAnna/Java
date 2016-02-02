/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.service;

import anna.deliveryservice.domain.Customer;
import anna.deliveryservice.exception.NoSuchCustomerException;
import anna.deliveryservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex
 */
@Service
public class SimpleCustomerService implements CustomerService {

    private CustomerRepository customerRepository;

    public SimpleCustomerService() {
    }

    @Autowired
    public SimpleCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void giveCard(Customer customer) {
        if (customerRepository.findById(customer.getId()) != null) {
            customer.setCard(0);
        } else {
            throw new NoSuchCustomerException();
        }
        customerRepository.update(customer);
    }

    @Override
    public Customer addSumToCard(Customer customer, int sum) {
        customer.addSumToCard(sum);
        return customerRepository.update(customer);
    }

    public Customer createCustomer(String name) {
        return new Customer(3, name);
    }
}
