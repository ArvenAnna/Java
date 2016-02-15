package anna.deliveryservice.infrastructure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;

/**
 * @author Anna
 * Example of BeanFactoryPostProcessor implementation
 */

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory clbf) throws BeansException {
        BeanDefinition bd = clbf.getBeanDefinition("newCustomer");
        ConstructorArgumentValues cav = bd.getConstructorArgumentValues();
//        System.out.println(cav.getArgumentCount());
//        System.out.println(cav.getArgumentValue(0, null).getValue());
        cav.getArgumentValue(0, null).setValue("Vassilissa");
        bd.setScope("singleton");
    }
    
}
