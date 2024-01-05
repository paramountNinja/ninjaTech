package com.ninja;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NinjaLoggingApplication {

    static Logger logger = LoggerFactory.getLogger(NinjaLoggingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NinjaLoggingApplication.class, args);

        System.out.println(System.getProperty("LOG_DATEFORMAT_PATTERN"));
        logger.trace("跟踪");
        logger.debug("调试");
        logger.info("信息");
        logger.warn("警告");
        logger.error("异常");
    }

}
