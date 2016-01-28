/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.infrastructure;

import anna.deliveryservice.repository.InMemCustomerRepository;
import anna.deliveryservice.repository.InMemOrderRepository;
import anna.deliveryservice.repository.InMemPizzaRepository;
import anna.deliveryservice.service.SimpleCustomerService;
import anna.deliveryservice.service.SimpleOrderService;
import anna.deliveryservice.service.SimplePizzaService;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alex
 */
public class JavaConfig implements Config{
    
    private Map<String,Class<?>> ifc2Class = new HashMap<>();

    public JavaConfig() {
        ifc2Class.put("pizzaRepository", InMemPizzaRepository.class);
        ifc2Class.put("orderRepository", InMemOrderRepository.class);
        ifc2Class.put("customerRepository", InMemCustomerRepository.class);
        ifc2Class.put("orderService", SimpleOrderService.class);
        ifc2Class.put("pizzaService", SimplePizzaService.class);
        ifc2Class.put("customerService", SimpleCustomerService.class);
    }
    
    @Override
    public <T> Class<T> getImpl(String ifc) {
        return (Class<T>) ifc2Class.get(ifc);
    }
}
