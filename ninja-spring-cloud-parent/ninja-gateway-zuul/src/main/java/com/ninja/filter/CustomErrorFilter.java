package com.ninja.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2023/5/7
 */
@Component
@Slf4j
public class CustomErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        Throwable throwable = requestContext.getThrowable();
        log.error("ErrorFilter..." + throwable.getCause().getMessage(), throwable);
        requestContext.setResponseStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        requestContext.getResponse().setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = null;
        try {
            printWriter = requestContext.getResponse().getWriter();
            printWriter.print("{\"respCode\":\"" + HttpStatus.INTERNAL_SERVER_ERROR + "\",\"respMsg\":\"" + throwable.getCause() + "\"}");
            printWriter.print("");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
        return null;
    }
}
