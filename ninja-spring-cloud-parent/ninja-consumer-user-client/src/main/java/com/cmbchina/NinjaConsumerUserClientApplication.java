package com.cmbchina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NinjaConsumerUserClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NinjaConsumerUserClientApplication.class, args);
    }

}
