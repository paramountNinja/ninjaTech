package com.ninja.logfacade;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2024/1/5
 */
public class Sl4jMain {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Sl4jMain.class);
        System.out.println(logger.getClass());
        logger.info("sl4j门面");
    }
}
