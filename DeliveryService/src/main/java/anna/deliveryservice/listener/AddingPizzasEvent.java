package anna.deliveryservice.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @author Anna
 * Event occurs if more pizzas are added to order
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
