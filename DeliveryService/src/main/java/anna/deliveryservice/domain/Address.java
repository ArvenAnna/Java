/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.domain;

/**
 *
 * @author Alex
 */
public class Address {
    
    private String city;

        public Address(String city) {
            this.city = city;
        }
        
        public void destroy(){
            System.out.println("Destroy Address");
        }
}
