package anna.deliveryservice.repository;

import anna.deliveryservice.domain.Order;

/**
 * @author Anna
 * Interface for repository classes of order entity
 */
public interface OrderRepository {
    Order save(Order order);
    Order findById(Long id);
    Order update(Order order);
}
