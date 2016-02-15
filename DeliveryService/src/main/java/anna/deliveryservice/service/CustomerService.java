package anna.deliveryservice.service;

import anna.deliveryservice.domain.Customer;

/**
 * @author Anna
 * Interface for service classes working with customer
 */
public interface CustomerService {
    
    void giveCard(Customer customer);
    
    Customer addSumToCard(Customer customer, int sum);
    
    Customer createCustomer(String name);
}
