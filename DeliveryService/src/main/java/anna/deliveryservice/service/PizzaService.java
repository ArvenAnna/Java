package anna.deliveryservice.service;

import anna.deliveryservice.domain.Pizza;

/**
 * @author Anna
 * Interface for service classes working with pizza
 */
public interface PizzaService {
    
    Pizza find(Long id);
}
