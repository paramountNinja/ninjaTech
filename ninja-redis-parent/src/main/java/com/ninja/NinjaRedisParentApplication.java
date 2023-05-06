package com.ninja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCircuitBreaker
@EnableScheduling
public class NinjaRedisParentApplication {

    public static void main(String[] args) {
        SpringApplication.run(NinjaRedisParentApplication.class, args);
    }

}
