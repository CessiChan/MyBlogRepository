package com.yida;

import com.yida.dao.UserInfoDOMapper;
import com.yida.dataObject.UserInfoDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
//此注解为了自动加载,启动内嵌tomcat
@SpringBootApplication(scanBasePackages = {"com.yida"})
@RestController
@MapperScan("com.yida.dao")
public class App {

    @Autowired
    private UserInfoDOMapper userInfoDOMapper;

    @RequestMapping("/")
    public String home() {
        UserInfoDO userInfoDO=userInfoDOMapper.selectByPrimaryKey("521aff9397e311e9a80d00ff4fdfe997");
        if(userInfoDO!=null) {
            return userInfoDO.getName();
        }else{
            return "用户信息不存在";
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(App.class, args);
    }
}
