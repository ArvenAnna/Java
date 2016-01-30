/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.service;

import anna.deliveryservice.domain.Customer;

/**
 *
 * @author Alex
 */
public interface CustomerService {
    void giveCard(Customer customer);
    Customer addSumToCard(Customer customer, int sum);
    Customer createCustomer(String name);
}
