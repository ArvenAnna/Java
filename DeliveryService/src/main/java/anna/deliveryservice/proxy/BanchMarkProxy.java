/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.proxy;

import anna.deliveryservice.annotation.BanchMark;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author Alex
 */
public class BanchMarkProxy {

    private Object realObject;

    public BanchMarkProxy(Object realObject) {
        this.realObject = realObject;
    }

    public Object getProxy() {
        Class<?>[] interfaceTypes = realObject.getClass().getInterfaces();
        Method[] methods = realObject.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BanchMark.class)) {
                return createProxy();
            }
        }
        return realObject;
    }

    private Object createProxy() {
        Class<?>[] interfaceTypes = realObject.getClass().getInterfaces();
        System.out.println("Proxy for " + realObject.getClass());

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue;
                System.out.println("BanchMark for method" + method.getName() + " of class " + realObject.getClass().getSimpleName());
                long time = System.nanoTime();
                returnValue = method.invoke(realObject, args);
                System.out.println(System.nanoTime()- time);
                return returnValue;
            }
        };
        return interfaceTypes[0].cast(Proxy.newProxyInstance(interfaceTypes[0].getClassLoader(), new Class[]{interfaceTypes[0]}, handler));
    }
}
