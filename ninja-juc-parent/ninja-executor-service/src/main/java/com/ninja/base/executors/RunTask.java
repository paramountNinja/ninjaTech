package com.ninja.base.executors;

import org.springframework.stereotype.Service;

/**
 * Created by ninja on 2020/1/29
 */
@Service
public class RunTask implements Runnable {

    private static int i = 1;

    public void run() {
        System.out.println("任务" + i++ + " " + "当前线程名：" + Thread.currentThread().getName());
    }
}
