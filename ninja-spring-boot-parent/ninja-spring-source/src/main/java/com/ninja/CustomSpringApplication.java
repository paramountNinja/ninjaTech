package com.ninja;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2023/7/22
 */
@SpringBootApplication
//优先级低于下面setDefaultProperties，且此方式无法注入yml
@PropertySource("classpath:appSource.properties")
public class CustomSpringApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication springApplication = new SpringApplication(CustomSpringApplication.class);
        //关闭横幅
        springApplication.setBannerMode(Banner.Mode.OFF);
        //启动时手动设置一个配置文件
        Properties properties = new Properties();
        InputStream resourceAsStream = CustomSpringApplication.class.getClassLoader().getResourceAsStream("app.properties");
        properties.load(resourceAsStream);

        springApplication.setDefaultProperties(properties);
        springApplication.run(args);

    }
}
