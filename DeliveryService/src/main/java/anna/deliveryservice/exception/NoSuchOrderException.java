package anna.deliveryservice.exception;

/**
 * @author Anna
 * Exception occurs if there is no given order in repositry but need to work with it
 */
public class NoSuchOrderException extends RuntimeException{

    public NoSuchOrderException() {
        super();
    }
    
}
