package anna.deliveryservice.repository;

import anna.deliveryservice.domain.Pizza;

/**
 * @author Anna
 * Interface for repository classes of pizza entity
 */
public interface PizzaRepository {
    Pizza findById(Long id);
}
