package com.cmbchina.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/4/14
 */
public class NinjaInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(methodInvocation.getMethod().getName() + "开始");
        Object result = methodInvocation.proceed();
        System.out.println(methodInvocation.getMethod().getName() + "结束");
        return result;
    }
}
