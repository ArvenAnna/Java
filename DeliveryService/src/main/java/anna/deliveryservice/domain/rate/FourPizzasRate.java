/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.domain.rate;

import anna.deliveryservice.annotation.MyComponent;
import anna.deliveryservice.domain.Order;
import anna.deliveryservice.domain.Order;
import anna.deliveryservice.domain.Pizza;
import anna.deliveryservice.domain.Pizza;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alex
 */
@MyComponent
public class FourPizzasRate implements Rate{

    @Override
    public Integer addRate(Order order) {
       int max = 0;
        if (order.getPizzas().size() > 4) {
            for (Pizza pizza : order.getPizzas()) {
                if (max < pizza.getPrice()) {
                    max = pizza.getPrice();
                }
            }
        }
        return (max * 30 / 100);
    }
}
