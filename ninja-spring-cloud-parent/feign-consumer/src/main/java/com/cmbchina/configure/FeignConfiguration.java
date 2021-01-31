package com.cmbchina.configure;

import feign.Feign;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/1/31
 */
@Configuration
public class FeignConfiguration {
    //@Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

    //@Bean
    public Request.Options options() {
        return new Request.Options(5000, 10000);
    }

    //@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
