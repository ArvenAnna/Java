/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.exception;

/**
 *
 * @author Alex
 */
public class TooManyPizzasException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Order can't has so many pizzas";
    }

    public TooManyPizzasException() {
        super();
    }
    
}
