package com.ninja.jdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ninja.jdbc.mapper")
public class NinjaJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(NinjaJdbcApplication.class, args);
    }

}
