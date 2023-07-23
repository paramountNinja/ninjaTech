package com.ninja.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2023/7/23
 */
public class CustomAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("around advice before");
        Object proceed = invocation.proceed();//这一行是执行后面切面的关键
        System.out.println("around advice after");
        return proceed;
    }
}
