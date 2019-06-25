package utils;
//IoC容器

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1.实例化bean
 * 2.保存bean
 * 3.提供bean
 * 4.每个bean产生唯一id
 */
public class IoCContainer {
    private Map<String, Object> beans = new ConcurrentHashMap<String, Object>();

    public Object getBean(String beanId) {
        return beans.get(beanId);
    }

    //委托IoC创建一个bean
    //clazz 要创建的bean的class
    //beanId要创建的Bean的Id
    //paramBeanId 要创建的Bean的依赖beanId，也是构造方法所需要的参数
    public void setBean(Class<?> clazz, String beanId, String... paramBeanId) {
        //1.组装构造方法所需要的参数值
        Object[] paramValues = new Object[paramBeanId.length];
        for (int i = 0; i < paramBeanId.length; i++) {
            paramValues[i] = beans.get(paramBeanId[i]);
        }
        //2.调用构造方法实例化bean
        Object bean = null;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean = constructor.newInstance(paramValues);
            } catch (InstantiationException e1) {
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            }
        }
        if (bean == null) {
            throw new RuntimeException("找不到合适的构造方法实例化bean!");
        }
        //3.将实例化的bean放入beans
        beans.put(beanId,bean);
    }
}
