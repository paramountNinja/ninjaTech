package com.ninja.config;

import com.ninja.vo.Administrator;
import com.ninja.vo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/3/14
 */
@Configuration
@ComponentScan("com.ninja")
public class MyConfig {

    @Bean
    public User userInstance() {
        User user = new User("ninja", 28);
        Administrator administrator = adminInstance();
        return user;
    }

    @Bean
    public Administrator adminInstance() {
        return new Administrator("123456");
    }
}
