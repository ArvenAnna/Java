package anna.deliveryservice.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Anna
 * Entity represents list of pizzas with it's current prices of order
 */

@Entity 
@Table(name = "order_details")
public class OrderDetail {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    Long id;
    
    @Column(name = "price")
    Integer price;
    
    @ManyToOne
    @JoinColumn(name = "pizza_id")
    Pizza pizza;

    public OrderDetail() {
    }

    public OrderDetail(Pizza pizza) {
        this.price = pizza.price;
        this.pizza = pizza;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.price);
        hash = 71 * hash + Objects.hashCode(this.pizza);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderDetail other = (OrderDetail) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.pizza, other.pizza)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "id=" + id + ", price=" + price + ", pizza=" + pizza + '}';
    }
    
}
