package utils.testPojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class Bean1Test {
    @Test
    public void test() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context.xml");
        Bean1 bean1 = context.getBean("bean1", Bean1.class);
        System.out.println("bean1 = " + bean1);
        Bean2 bean2 = context.getBean("bean2", Bean2.class);
        System.out.println("bean2 = " + bean2);

       // Bean3Factory bean3Factory = new Bean3Factory();
        //Bean3 bean3 = bean3Factory.getBean3();
        Bean3 bean3=context.getBean("bean3",Bean3.class);
        System.out.println("bean3 = " + bean3);
    }
}