package com.ninja.yummy.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Desc RestConfig
 * @Author ninja
 * @Date Created on 2021/5/4
 */
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    public RestTemplate restTemplateNoLoadBalanced() {
        return new RestTemplate();
    }
}
