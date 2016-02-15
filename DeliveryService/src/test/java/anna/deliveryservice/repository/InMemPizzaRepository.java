package anna.deliveryservice.repository;

import anna.deliveryservice.annotation.BanchMark;
import anna.deliveryservice.domain.Pizza;
import java.util.Map;
import javax.annotation.PostConstruct;

/**
 * @author Anna
 * In mem implementation of PizzaRepository
 */

public class InMemPizzaRepository implements PizzaRepository{
    
    private Map<Integer, Pizza> pizzas;
    
    public void setPizzas(Map<Integer, Pizza> pizzas) {
        this.pizzas = pizzas;
    } 

    @Override
    @BanchMark
    public Pizza findById(Long id) {
        return pizzas.get(id.intValue());
    }
    
    @PostConstruct
    public void init(){
        System.out.println("iniiiiiiiiiiiiiiiiiiit");
    }
}
