package anna.deliveryservice.infrastructure;

import anna.deliveryservice.proxy.BanchMarkProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Anna
 * BeanPostProcessor for benchmarking
 */

//for such class inheritance of application contexts not works
public class BenchmarkBeanPostProcessor implements BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization(Object o, String string) throws BeansException {
        System.out.println("Before: " + o.getClass().getSimpleName());
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(final Object o, String string) throws BeansException {
        BanchMarkProxy banchMark = new BanchMarkProxy(o);
        System.out.println("After: " + string);
        return banchMark.getProxy();
    }
             
}
