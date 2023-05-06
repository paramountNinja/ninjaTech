package com.ninja.ninjaspringcloudbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class NinjaSpringCloudBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(NinjaSpringCloudBaseApplication.class, args);
    }

}
