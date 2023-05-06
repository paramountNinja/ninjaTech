package com.ninja.spring.service;

import org.springframework.stereotype.Component;

/**
 * Created by ninja on 2020/2/10
 */
@Component
public class Demo3Service extends AbstractService {

    private static int i = 1;

    @Override
    public void invoke() {
        System.out.println("任务" + i++ + " " + "demo3当前线程名：" + Thread.currentThread().getName());
    }
}
