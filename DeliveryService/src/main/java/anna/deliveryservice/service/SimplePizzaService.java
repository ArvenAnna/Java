package anna.deliveryservice.service;

import anna.deliveryservice.annotation.BanchMark;
import anna.deliveryservice.domain.Pizza;
import anna.deliveryservice.repository.PizzaRepository;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Anna
 * Implementation of service working with customer
 */

@Service
public class SimplePizzaService implements PizzaService{
    
    private PizzaRepository pizzaRepository;
    
    @Autowired
    public SimplePizzaService(PizzaRepository pizzaRepository){
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    @BanchMark
    public Pizza find(Long id) {
        return pizzaRepository.findById(id);
    } 
    
    @PostConstruct
    public void init(){
        System.out.println("I'm postconstruct");
    }
}