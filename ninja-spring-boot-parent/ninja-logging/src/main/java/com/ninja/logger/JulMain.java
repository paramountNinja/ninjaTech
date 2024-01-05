package com.ninja.logger;

import java.util.logging.Logger;

/**
 * @Desc JUL
 * @Author ninja
 * @Date Created on 2024/1/5
 */
public class JulMain {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(JulMain.class.getName());
        System.out.println(logger.getClass());
        logger.info("java util logging 官方自带");
    }
}
