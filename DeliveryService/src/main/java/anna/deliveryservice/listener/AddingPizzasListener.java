/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.listener;

import org.springframework.context.ApplicationListener;

/**
 *
 * @author Alex
 */
public class AddingPizzasListener implements ApplicationListener<AddingPizzasEvent>{

    @Override
    public void onApplicationEvent(AddingPizzasEvent applicationEvent) {
        System.out.println(" CustomEventListener received "
                + applicationEvent.getClass() + "\n at "
                + "\n with Source as "
                + applicationEvent.getSource().getClass());
        System.out.println("The message is " + applicationEvent.getMsg());
    }  
}
