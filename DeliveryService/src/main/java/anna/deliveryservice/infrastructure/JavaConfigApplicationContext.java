package anna.deliveryservice.infrastructure;

import anna.deliveryservice.annotation.PostCreate;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import anna.deliveryservice.proxy.BanchMarkProxy;

/**
 * @author Anna
 * Custom DI Container
 */

public class JavaConfigApplicationContext implements ApplicationContext {

    private Config config;
    private Map<String, Object> beans = new HashMap<>();//beans

    public JavaConfigApplicationContext(Config config) {
        this.config = config;
    }

    @Override
    public Object getBean(String beanName) throws Exception {
        Class<?> type = config.getImpl(beanName);

        Object bean = beans.get(beanName);
        if (bean != null) {
            return bean;
        }

        BeanBuilder builder = new BeanBuilder(type);
        builder.construct();
        builder.afterConstruct();
        builder.createProxy();
        bean = builder.build();

        beans.put(beanName, bean);
        return bean;
    }

    class BeanBuilder {

        private Class<?> type;
        Object bean;

        public BeanBuilder(Class<?> type) {
            this.type = type;
        }

        public void construct() throws Exception {
            Constructor<?> constructor = type.getConstructors()[0]; //getParameters
            Class<?>[] parameters = constructor.getParameterTypes();//Parameters[]
            int paramLength = parameters.length;

            if (parameters.length == 0) {
                bean = type.newInstance();
            } else {
                Object[] params = new Object[paramLength];
                for (int i = 0; i < paramLength; i++) {
                    String name = parameters[i].getSimpleName();
                    StringBuilder str = new StringBuilder(name);
                    str.setCharAt(0, String.valueOf(str.charAt(0)).toLowerCase().toCharArray()[0]);
                    name = new String(str);
                    params[i] = getBean(name);
                }
                bean = constructor.newInstance(params);
            }
        }

        public void afterConstruct() throws Exception {
            Class<?> presiceType = bean.getClass();
            Method[] methods = presiceType.getMethods();

            for (Method method : methods) {

                Class<?>[] parameters = method.getParameterTypes();
                if (parameters.length == 0) {
                    if (method.isAnnotationPresent(PostCreate.class) && !method.getName().equals("init")) {
                        method.invoke(bean);
                    }
                    if (method.getName().equals("init")) {
                        method.invoke(bean);
                    }
                }
            }
        }

        public void createProxy() {
            BanchMarkProxy banchMark = new BanchMarkProxy(bean);
            bean = banchMark.getProxy();
        } 
        
        public Object build() {
            return bean;
        }
    } 
}
