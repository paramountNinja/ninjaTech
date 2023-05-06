package com.ninja.config;

import com.ninja.applicationevent.JavaStackEvent;
import com.ninja.applicationevent.ReaderListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/4/15
 */
@Configuration
@Slf4j
@ComponentScan(value = "com.ninja")
@EnableAspectJAutoProxy
public class ObserverConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return (args -> {
            log.info("发布事件：什么是观察者模式？");
            context.publishEvent(new JavaStackEvent("什么是观察者模式？"));
        });
    }

    @Bean
    public ReaderListener readerListener1() {
        return new ReaderListener("kier");
    }

    @Bean
    public ReaderListener readerListener2() {
        return new ReaderListener("xinihi");
    }

    @Bean
    public ReaderListener readerListener3() {
        return new ReaderListener("enzi");
    }

    @Bean
    public ReaderListener readerListener4() {
        return new ReaderListener("ninja");
    }
}
