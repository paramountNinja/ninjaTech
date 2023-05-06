package com.ninja.remote.config;

import feign.Logger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2022/4/25
 */
public class CustomFeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConvertersObjectFactory;

    /*@Bean
    @Primary
    @Scope("prototype")
    public Encoder multipartFormEncoder() {
        SpringEncoder defaultEncoder = new SpringEncoder(this.messageConvertersObjectFactory);
        return new VoEncoder(defaultEncoder);
    }*/
}
