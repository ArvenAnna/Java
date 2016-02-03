/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.infrastructure;

import anna.deliveryservice.proxy.BanchMarkProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *
 * @author Alex
 */
//for such class inheritance of application contexts not works
public class BenchmarkBeanPostProcessor implements BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization(Object o, String string) throws BeansException {
        //before calling init methods
        System.out.println("Before: " + string);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String string) throws BeansException {
        BanchMarkProxy banchMark = new BanchMarkProxy(o);
        System.out.println("After: " + string);
        return banchMark.getProxy();
    }
    
}
