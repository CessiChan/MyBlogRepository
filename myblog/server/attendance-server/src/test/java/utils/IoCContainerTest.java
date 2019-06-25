package utils;

import org.junit.Before;
import org.junit.Test;
import utils.testPojo.*;

public class IoCContainerTest {
    private IoCContainer ioCContainer = new IoCContainer();

    @Before
    public void before() {
        ioCContainer.setBean(Audi.class, "audi");
        ioCContainer.setBean(Toyota.class, "toyota");
        ioCContainer.setBean(ZhangSan.class, "zhangSan", "audi");
        ioCContainer.setBean(LiSi.class, "liSi", "toyota");
    }

    @Test
    public void test() {
        Human zhangSan = (Human) ioCContainer.getBean("zhangSan");
        zhangSan.goHome();
        Human liSi = (Human) ioCContainer.getBean("liSi");
        liSi.goHome();
    }
}