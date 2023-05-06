package com.ninja.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2022/12/24
 */
@Component
@Slf4j
public class HystrixDemo1 {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @HystrixCommand(fallbackMethod = "ninjaFallBack", commandKey = "key1")//默认使用配置文件的全局配置，若不配置默认是1s
    /*@HystrixCommand(fallbackMethod = "ninjaFallBack", commandProperties =
            {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            })*/
    public String service(int i, String s) {
        String key = "code:set";
        long startTime = System.currentTimeMillis();
        List<String> pop = stringRedisTemplate.opsForSet().pop(key, 5);
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(pop);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello service";
    }

    public String ninjaFallBack(int i, String s) {
        System.out.println("param:" + i + "," + s);
        System.out.println("hello fallback111");
        return "hello fallback";
    }

    @Scheduled(fixedRateString = "${code.stock.fixedDelay}")
    public void test() throws Exception {
        /*Thread.sleep(5000);*/
        System.out.println(new Date() + Thread.currentThread().getName() + Thread.currentThread().getId() + "   hello scheduled");
    }
}
