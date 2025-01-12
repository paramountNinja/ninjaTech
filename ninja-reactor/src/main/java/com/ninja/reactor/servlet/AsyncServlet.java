package com.ninja.reactor.servlet;

import com.ninja.reactor.servlet.threadpool.AsyncRejectedExceptionHandler;
import com.ninja.reactor.servlet.threadpool.AsyncRequestWrapper;
import com.ninja.reactor.servlet.threadpool.AsyncThreadFactory;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Desc http://localhost:8080/async?a=1
 * since servlet 3.0
 * @Author ninja
 * @Date Created on 2024/12/22
 */
@WebServlet(value = "/async", asyncSupported = true)
@Slf4j
public class AsyncServlet extends HttpServlet {

    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1, 1, 0L, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(1),
            AsyncThreadFactory.builder().threadName("async-thread-pool").build(),
            new AsyncRejectedExceptionHandler());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("request:{}, current thread:{}", req.getQueryString(), Thread.currentThread().getName());
        //保存请求上下文，以便异步线程可以获取
        AsyncContext asyncContext = req.startAsync();
        AsyncRequestWrapper runnable = AsyncRequestWrapper.builder()
                .asyncContext(asyncContext)
                .request(asyncContext.getRequest())
                .response(asyncContext.getResponse())
                .thread(Thread.currentThread())
                .build();
        executor.execute(runnable);
    }
}
