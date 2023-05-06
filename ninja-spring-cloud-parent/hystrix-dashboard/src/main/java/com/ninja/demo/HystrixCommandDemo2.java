package com.ninja.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2022/12/24
 */
@Component
public class HystrixCommandDemo2 {

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String service() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "service";
    }


    public String helloFallback() {
        return "halo";
    }
}
