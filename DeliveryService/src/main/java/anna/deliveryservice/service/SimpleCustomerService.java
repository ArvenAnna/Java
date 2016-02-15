package anna.deliveryservice.service;

import anna.deliveryservice.domain.Card;
import anna.deliveryservice.domain.Customer;
import anna.deliveryservice.exception.NoSuchCustomerException;
import anna.deliveryservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Anna
 * Implementation of service working with customer
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
            customer.setCard(new Card());
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
        return new Customer(3L, name);
    }
}
