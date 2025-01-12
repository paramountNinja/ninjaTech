package com.ninja.reactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2024/12/22
 */
@SpringBootApplication
@ServletComponentScan
public class DemoAsyncApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoAsyncApplication.class, args);
    }
}
