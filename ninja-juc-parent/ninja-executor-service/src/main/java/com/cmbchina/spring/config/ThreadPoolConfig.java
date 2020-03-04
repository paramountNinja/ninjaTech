package com.cmbchina.spring.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

/**
 * Created by ninja on 2020/1/30
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Bean(value = "threadPoolInstance")
    public ExecutorService createExecutorServiceInstance() {

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("thread-pool-ninja-%d")
                .build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10, 10,
                30L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        return threadPoolExecutor;
    }
}
