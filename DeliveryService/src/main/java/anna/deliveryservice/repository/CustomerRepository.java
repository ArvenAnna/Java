/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.repository;

import anna.deliveryservice.domain.Customer;

/**
 *
 * @author Alex
 */
public interface CustomerRepository {
    Customer update(Customer customer);
    Customer findById(long id);
}
