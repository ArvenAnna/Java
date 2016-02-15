package anna.deliveryservice.infrastructure;

import anna.deliveryservice.service.SimpleCustomerService;
import anna.deliveryservice.service.SimpleOrderService;
import anna.deliveryservice.service.SimplePizzaService;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anna
 * Configs with bean map for custom application context
 */

public class JavaConfig implements Config{
    
    private Map<String,Class<?>> ifc2Class = new HashMap<>();

    public JavaConfig() {
        ifc2Class.put("orderService", SimpleOrderService.class);
        ifc2Class.put("pizzaService", SimplePizzaService.class);
        ifc2Class.put("customerService", SimpleCustomerService.class);
    }
    
    @Override
    public <T> Class<T> getImpl(String ifc) {
        return (Class<T>) ifc2Class.get(ifc);
    }
}
