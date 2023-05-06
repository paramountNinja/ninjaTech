package com.ninja;

import com.ninja.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/3/14
 */
public class MyMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Object userService = context.getBean("userInstance");
        Object userService1 = context.getBean("userInstance");
        System.out.println(userService);
        System.out.println(userService);
    }
}
