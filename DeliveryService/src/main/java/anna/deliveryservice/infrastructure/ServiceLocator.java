package anna.deliveryservice.infrastructure;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Anna
 * Locator for custom container
 */

public class ServiceLocator {
    
    private static ServiceLocator serviceLocator;
    private JavaConfig config = new JavaConfig();

    private ServiceLocator() {
    }
    
    public static ServiceLocator getInstance(){
        if(serviceLocator == null){
            serviceLocator = new ServiceLocator();
        }
        return serviceLocator;
    }
            
    public <T> T createImplementation(String service){
        T implementation = null;
        try {
            implementation = (T)config.getImpl(service).newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return implementation;
    }
            
}
