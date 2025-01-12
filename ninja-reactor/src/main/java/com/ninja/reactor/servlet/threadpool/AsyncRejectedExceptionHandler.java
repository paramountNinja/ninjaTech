package com.ninja.reactor.servlet.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2024/12/22
 */
@Slf4j
public class AsyncRejectedExceptionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        log.info("当前异步处理线程（异常）:{}", Thread.currentThread());
        AsyncRequestWrapper asyncRequestWrapper = (AsyncRequestWrapper) r;
        try {
            ((AsyncRequestWrapper) r).getResponse().getWriter().println("too many request");
        } catch (IOException e) {
            e.printStackTrace();
        }
        asyncRequestWrapper.getAsyncContext().complete();
    }
}
