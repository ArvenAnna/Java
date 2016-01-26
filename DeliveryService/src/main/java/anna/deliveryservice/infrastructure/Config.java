/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.infrastructure;

/**
 *
 * @author Alex
 */
public interface Config {
     public <T> Class<T> getImpl(String ifc);
}
