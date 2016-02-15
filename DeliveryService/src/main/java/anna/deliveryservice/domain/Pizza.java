package anna.deliveryservice.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Anna
 * Entity represents pizza of pizza service
 */

@Entity 
@Table(name = "pizza")
public class Pizza {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false) 
    Long id;
    
    @Column(name = "name")
    String name;
    
    @Column(name = "pizzatype")
    @Enumerated(EnumType.STRING)
    PizzaType pizzaType;
    
    @Column(name = "price")
    Integer price;

    public Pizza() {
    }

    public Pizza(Long id, String name, PizzaType pizzaType, Integer price) {
        this.id = id;
        this.name = name;
        this.pizzaType = pizzaType;
        this.price = price;
    }

    public Pizza(Long id, String name, PizzaType pizzaType) {
        this.id = id;
        this.name = name;
        this.pizzaType = pizzaType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }
    

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.pizzaType);
        hash = 41 * hash + Objects.hashCode(this.price);
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
        final Pizza other = (Pizza) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.pizzaType != other.pizzaType) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pizza{" + "id=" + id + ", name=" + name + ", pizzaType=" + 
                pizzaType + ", price=" + price + '}';
    }
    
    public enum PizzaType {
        Vegetarian, Sea, Meat
    }
    
}
