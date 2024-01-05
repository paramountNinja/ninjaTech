package com.ninja.logger;

import org.apache.log4j.Logger;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2024/1/5
 */
public class Log4jMain {

    /*
     * 需要加配置文件log4j.properties,否则报
     * log4j:WARN No appenders could be found for logger (com.ninja.logger.Log4jMain).
       log4j:WARN Please initialize the log4j system properly.
       log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
     *
     */

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Log4jMain.class);
        System.out.println(logger.getClass());
        logger.info("log4j 开源框架");
    }
}
