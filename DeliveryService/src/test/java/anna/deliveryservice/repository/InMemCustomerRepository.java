package anna.deliveryservice.repository;

import anna.deliveryservice.domain.Customer;
import anna.deliveryservice.exception.NoSuchCustomerException;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;

/**
 * @author Anna
 * In mem implementation of CustomerRepository
 */

@Repository
public class InMemCustomerRepository implements CustomerRepository{

    private final Set<Customer> customers = new HashSet<Customer>();
    
    @Override
    public Customer findById(Long id) {
        for(Customer customer:customers){
            if(id == customer.getId()){
                return customer;
            }
        }
        return null;
    }
    
    @Override
    public Customer update(Customer customer) {
        for(Customer cust:customers){
            if(customer.getId().equals(cust.getId())){
                customers.remove(cust);
                customers.add(customer);
                return customer;
            }
        }      
        throw new NoSuchCustomerException();
    }
    
    public void init(){
       customers.add(new Customer(1L,"Vasiliy"));
       customers.add(new Customer(2L,"Valeriy"));
    }
    
}
