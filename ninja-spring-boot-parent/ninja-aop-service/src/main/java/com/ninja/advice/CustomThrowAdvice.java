package com.ninja.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2023/7/23
 */
public class CustomThrowAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        //对应参数ex可以修改为其他的具体报错,比如空指针异常等
        System.out.println("throw advice execute");
    }
}
