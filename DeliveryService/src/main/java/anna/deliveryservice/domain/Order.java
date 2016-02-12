/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.domain;

import anna.deliveryservice.domain.rate.Rate;
import anna.deliveryservice.exception.TooManyPizzasException;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 *
 */
@Component
@Entity 
@Table(name = "order")
public class Order {

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false) 
    long id;
    
    @OneToMany()
    @JoinColumn(name = "order_id")
    List<OrderDetail> details;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
    
    @Column(name = "status")         
    @Enumerated(EnumType.STRING)
    Status status;
    
    @Temporal(value=TemporalType.DATE)
    @Column(name = "date")
    Date date;
    
    @Transient
    private final int MAX_PIZZAS_IN_ORDER = 10;
    
    @Autowired
    @Transient
    private List<Rate> rates;

    public Order() {
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    
    
    public void addMorePizzaz(List<Pizza> morePizzas){
        checkForTooManyPizzasException((details.size()+ morePizzas.size()));
        for(Pizza p:morePizzas){
            details.add(new OrderDetail(p.price, p));
        }
    }

    public Integer getpureCost() {
        Integer sum = 0;
        for (OrderDetail det : details) {
            sum += det.price;
        }
        return sum;
    }
    
    public Integer getRateCost() {
        Integer cost = getpureCost();
        if(rates != null){
            for(Rate rate:rates){
                cost = cost - rate.addRate(this);
            }
        }
        return cost;
    }

    private void checkForTooManyPizzasException(Integer pizzaCount) {
        if (pizzaCount > MAX_PIZZAS_IN_ORDER) {
            throw new TooManyPizzasException() {
                @Override
                public String getMessage() {
                    return "Order can't has more then " + MAX_PIZZAS_IN_ORDER + " pizzas";
                }
            };
        }
    }

    public long getId() {
        return id;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;     
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        NEW, IN_PROGRSS, CANCELED, DONE
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customer=" + 
                customer + ", status=" + status + ", MAX_PIZZAS_IN_ORDER=" + 
                MAX_PIZZAS_IN_ORDER + ", rates=" + rates + '}';
    }

    
}
