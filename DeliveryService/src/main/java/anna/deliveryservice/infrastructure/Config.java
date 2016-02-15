package anna.deliveryservice.infrastructure;

/**
 * @author Anna
 * Interface for container configuration
 */
public interface Config {
     public <T> Class<T> getImpl(String ifc);
}
