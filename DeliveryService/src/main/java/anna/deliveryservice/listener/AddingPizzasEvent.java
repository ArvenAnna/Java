/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.listener;

import org.springframework.context.ApplicationEvent;

/**
 *
 * @author Alex
 */
public class AddingPizzasEvent extends ApplicationEvent{

    final String msg;

    public String getMsg() {
        return msg;
    }

    public AddingPizzasEvent(Object source, final String msg) {
        super(source);
        this.msg = msg;
        System.out.println("Created a Custom event");
    }

    @Override
    public String toString() {
        return "CustomMsgEvent msg: " + this.msg;
    }
}
