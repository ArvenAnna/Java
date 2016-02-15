package anna.deliveryservice.listener;

import org.springframework.context.ApplicationListener;

/**
 * @author Anna
 * Event Listener for adding extra pizzas
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
