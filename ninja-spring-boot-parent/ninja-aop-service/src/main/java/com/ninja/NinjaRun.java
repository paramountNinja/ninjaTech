package com.ninja;

import com.ninja.config.InterceptorConfig;
import com.ninja.config.NinjaConfiguration;
import com.ninja.service.DemoService;
import com.ninja.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/4/14
 */
public class NinjaRun {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                NinjaConfiguration.class, InterceptorConfig.class);
        //DemoService demoService = (DemoService) context.getBean("demoService");
        //demoService.check1("param");


        //NinjaConfiguration 中beanNameAutoProxyCreator
        UserService userService = (UserService) context.getBean("userService");
        userService.test();
    }
}
