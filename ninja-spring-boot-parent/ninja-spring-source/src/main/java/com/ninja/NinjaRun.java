package com.ninja;

import com.ninja.config.ObserverConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/4/15
 */
public class NinjaRun {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ObserverConfiguration.class
        );
        CommandLineRunner commandLineRunner = context.getBean(CommandLineRunner.class);
        commandLineRunner.run();
    }
}
