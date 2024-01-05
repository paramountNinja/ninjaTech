package com.ninja.logfacade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2024/1/5
 */
public class JCLMain {

    public static void main(String[] args) {
        Log log = LogFactory.getLog(JCLMain.class);
        System.out.println(log.getClass());
        log.info("JCL门面");

    }
}
