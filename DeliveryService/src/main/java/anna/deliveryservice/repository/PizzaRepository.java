/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.repository;

import anna.deliveryservice.domain.Pizza;

/**
 *
 * @author Alex
 */
public interface PizzaRepository {
    Pizza find(Integer id);
}
