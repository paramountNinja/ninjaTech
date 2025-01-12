package com.ninja.reactor.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2024/12/22
 */
@WebServlet(value = "/sync")
@Slf4j
public class SyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("request:{}, current thread:{}", req.getQueryString(), Thread.currentThread().getName());
        process(req, resp);
    }


    private void process(HttpServletRequest req, HttpServletResponse resp) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            resp.getWriter().println("sync");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
