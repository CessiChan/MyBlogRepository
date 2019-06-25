package utils;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.testPojo.Toyota;


//IoC交给Spring
public class SpringIocTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Toyota toyota = context.getBean("toyota", Toyota.class);
        System.out.println("bean = " + toyota);
    }
}
