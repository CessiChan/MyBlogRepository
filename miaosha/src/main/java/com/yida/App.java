package com.yida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
//此注解为了自动加载,启动内嵌tomcat
@EnableAutoConfiguration
@RestController
public class App {

    @RequestMapping("/")
    public String home(){
        return "HelloWorld!";
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(App.class,args);
    }
}
