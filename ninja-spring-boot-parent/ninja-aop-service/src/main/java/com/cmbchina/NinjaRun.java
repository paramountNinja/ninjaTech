package com.cmbchina;

import com.cmbchina.config.InterceptorConfig;
import com.cmbchina.config.NinjaConfiguration;
import com.cmbchina.service.DemoService;
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
        DemoService demoService = (DemoService) context.getBean("demoService");
        demoService.check1("param");
    }
}
