package com.ninja.spring.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by ninja on 2020/1/30
 */
@Service
public class Demo2Service {

    private static int i = 1;

    @Async("threadPoolInstance")
    public void handle() {
        System.out.println("任务" + i++ + " " + "demo2当前线程名：" + Thread.currentThread().getName());
    }
}
