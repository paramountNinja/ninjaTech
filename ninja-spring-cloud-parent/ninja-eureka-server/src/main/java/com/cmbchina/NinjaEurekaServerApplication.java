package com.cmbchina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NinjaEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NinjaEurekaServerApplication.class, args);
    }

}
