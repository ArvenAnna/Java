package anna.deliveryservice.domain.rate;

import anna.deliveryservice.domain.Order;

/**
 * @author Anna
 * Interface for any type of rates
 */
public interface Rate {
    /**
     * Calculates rate for given order
     * @param order - order object for which rate will be calculated
     * @return sum of the rate or 0 if rate can't be applied
     */
    Integer addRate(Order order); 
}
