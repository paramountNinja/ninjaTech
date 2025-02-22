package com.example.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.sharding.mapper")
public class NinjaShardingSphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(NinjaShardingSphereApplication.class, args);
    }

}
