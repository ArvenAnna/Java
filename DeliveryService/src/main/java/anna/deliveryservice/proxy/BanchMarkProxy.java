package anna.deliveryservice.proxy;

import anna.deliveryservice.annotation.BanchMark;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.log4j.Logger;

/**
 * @author Anna
 * Proxy class for benchmarking
 */
public class BanchMarkProxy {

    private static Logger log = Logger.getLogger(BanchMarkProxy.class);
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

        Class<?> proxyType = realObject.getClass();
        
        for (Class<?> c : proxyType.getInterfaces()) {
            if (c.getName().equals("org.springframework.cglib.proxy.Factory")) {
                proxyType = proxyType.getSuperclass();
                break;
            }
        }

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = null;
                Method[] realMethods = realObject.getClass().getMethods();
                for (Method realMethod : realMethods) {
                    if (realMethod.getName().equals(method.getName()) && realMethod.isAnnotationPresent(BanchMark.class)) {
                        long time = System.nanoTime();
                        returnValue = method.invoke(realObject, args);
                        log.info("BanchMark for method " + method.getName() + " of class " + realObject.getClass().getSimpleName());
                        log.info(System.nanoTime() - time);
                        break;
                    }
                }
                if (returnValue == null) {
                    returnValue = method.invoke(realObject, args);
                }
                return returnValue;
            }
        };    
        return Proxy.newProxyInstance(proxyType.getClassLoader(), proxyType.getInterfaces(), handler);
    }
}
