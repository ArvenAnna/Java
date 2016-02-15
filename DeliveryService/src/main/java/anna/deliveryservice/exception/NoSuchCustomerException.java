package anna.deliveryservice.exception;

/**
 * @author Anna
 * Exception occurs if there is no given customer in repositry but need to work with him
 */
public class NoSuchCustomerException extends RuntimeException{

    public NoSuchCustomerException() {
        super();
    }
    
}
