package anna.deliveryservice.infrastructure;

import anna.deliveryservice.repository.PizzaRepository;

/**
 * @author Anna
 * Interface for custom DI container
 */
public interface ApplicationContext {

    public Object getBean(String beanName) throws Exception;
    
}
