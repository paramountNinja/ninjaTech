package com.ninja.reactor.servlet.threadpool;

import lombok.Builder;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2024/12/22
 */
@Builder
public class AsyncThreadFactory implements ThreadFactory {

    private final ThreadFactory defaultFactory = Executors.defaultThreadFactory();

    private final AtomicInteger threadNumber = new AtomicInteger(1);

    private final String threadName;

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = defaultFactory.newThread(r);
        thread.setName(this.threadName + "-" + threadNumber.getAndIncrement());
        return thread;
    }
}
