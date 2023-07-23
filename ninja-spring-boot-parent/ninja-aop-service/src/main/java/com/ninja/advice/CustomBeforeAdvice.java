package com.ninja.advice;

import org.aopalliance.aop.Advice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2023/7/23
 */
@Component
public class CustomBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("custom before advice execute");
    }
}
