package anna.deliveryservice.repository;

import anna.deliveryservice.domain.Order;
import anna.deliveryservice.exception.NoSuchOrderException;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;

/**
 * @author Anna
 * In mem implementation of OrderRepository
 */

@Repository
public class InMemOrderRepository implements OrderRepository {

    private final Set<Order> orders = new HashSet<>();

    @Override
    public Order save(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public Order findById(Long id) {
        for(Order order:orders){
            if(id.equals(order.getId())){
                return order;
            }
        }
        throw new NoSuchOrderException();
    }

    @Override
    public Order update(Order order) {
        for(Order ord:orders){
            if(order.getId().equals(ord.getId())){
                orders.remove(ord);
                return order;
            }
        }
        orders.add(order);
        throw new NoSuchOrderException();
    }
}
