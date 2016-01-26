/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.infrastructure;

import anna.deliveryservice.repository.PizzaRepository;

/**
 *
 * @author Alex
 */
public interface ApplicationContext {

    public Object getBean(String beanName) throws Exception;
    
}
