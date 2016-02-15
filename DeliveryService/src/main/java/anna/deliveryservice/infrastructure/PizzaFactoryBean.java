package anna.deliveryservice.infrastructure;

import anna.deliveryservice.domain.Pizza;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author Anna
 * Example of FactoryBean<> implementation
 */

public class PizzaFactoryBean implements FactoryBean<Pizza>{

    private Long id;
    private String name;
    private Pizza.PizzaType type;
    private Integer price;
    
    @Override
    public Pizza getObject() throws Exception {
        return new Pizza(id,name,type,price);
    }

    @Override
    public Class<?> getObjectType() {
        return Pizza.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Pizza.PizzaType type) {
        this.type = type;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
