/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.domain;

import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alex
 */
@Component
public class Address {

    @Value("Kiev")
    private String city;

    public Address() {
    }

    public Address(String city) {
        this.city = city;
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy Address");
    }
}
