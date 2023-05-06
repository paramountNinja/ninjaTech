package com.ninja.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2020/3/18
 */
@Slf4j
@Aspect
@Component
public class DemoAspect {
    @Autowired
    private ObjectMapper objectMapper;


    @Around(value = "execution(* com.ninja..service..*Service.*(..))")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println(proceedingJoinPoint.getSignature() + " : before");
        Object[] args = proceedingJoinPoint.getArgs();
        /*if (args.length > 0) {
            System.out.println(objectMapper.writeValueAsString(args[0]));
        }*/
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println(proceedingJoinPoint.getSignature() + " : after");
        return proceed;
    }
}
