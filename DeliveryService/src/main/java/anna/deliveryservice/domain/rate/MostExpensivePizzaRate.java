package anna.deliveryservice.domain.rate;

//import anna.deliveryservice.annotation.MyComponent;
import anna.deliveryservice.annotation.MyComponent;
import anna.deliveryservice.domain.Order;
import anna.deliveryservice.domain.OrderDetail;

/**
 * @author Anna
 * Represents rate for order which has more then defined pizzas amount
 * Rate can be applied to the one of the most expensive pizza in order only
 */

@MyComponent
public class MostExpensivePizzaRate implements Rate{
    
    private final int MIN_PIZZAS_COUNT = 4;
    private final int RATE_PERCENT = 30;

    @Override
    public Integer addRate(Order order) {
       int max = 0;
        if (order.getDetails().size() > MIN_PIZZAS_COUNT) {
            for (OrderDetail det : order.getDetails()) {
                if (max < det.getPrice()) {
                    max = det.getPrice();
                }
            }
        }
        return (max * RATE_PERCENT / 100);
    }
}
