package utils.testPojo.beanInjection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class BeanTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Bean bean=context.getBean("beanInjection",Bean.class);
        System.out.println("bean = "+bean);
    }
}