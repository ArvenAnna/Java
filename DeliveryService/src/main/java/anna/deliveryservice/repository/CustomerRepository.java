package anna.deliveryservice.repository;

import anna.deliveryservice.domain.Customer;

/**
 * @author Anna
 * Interface for repository classes of customer entity
 */
public interface CustomerRepository {
    Customer update(Customer customer);
    Customer findById(Long id);
}
