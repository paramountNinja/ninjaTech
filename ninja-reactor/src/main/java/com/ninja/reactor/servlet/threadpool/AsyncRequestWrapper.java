package com.ninja.reactor.servlet.threadpool;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2024/12/22
 */
@Slf4j
@Data
@Builder
public class AsyncRequestWrapper implements Runnable {
    private AsyncContext asyncContext;
    private ServletRequest request;
    private ServletResponse response;
    private Thread thread;

    @Override
    public void run() {
        process(asyncContext, request, response);
        //销毁异步请求的上下文
        asyncContext.complete();
    }

    private void process(AsyncContext asyncContext, ServletRequest request, ServletResponse response) {
        log.info("当前异步处理线程:{}", Thread.currentThread());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            response.getWriter().println("async");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
