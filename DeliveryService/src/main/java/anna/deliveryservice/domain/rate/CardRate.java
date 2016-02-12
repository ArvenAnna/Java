/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.domain.rate;

import anna.deliveryservice.annotation.MyComponent;
import anna.deliveryservice.domain.Order;
import anna.deliveryservice.domain.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alex
 */
@MyComponent
public class CardRate implements Rate{

    @Override
    public Integer addRate(Order order){
        int cardRate = 0;
        Integer cardSum = order.getCustomer().getCard().getSum();
        if (cardSum != null) {
            cardRate = cardSum * 10 / 100;
            if (cardRate > order.getpureCost() * 30 / 100) {
                cardRate = order.getpureCost() * 30 / 100;
            }
        }
        return cardRate;
    }
}
