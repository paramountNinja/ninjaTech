package com.ninja.proxyfactory;

import com.ninja.advice.CustomAfterReturningAdvice;
import com.ninja.advice.CustomAroundAdvice;
import com.ninja.advice.CustomBeforeAdvice;
import com.ninja.advice.CustomThrowAdvice;
import com.ninja.service.UserService;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @Desc spring 对aop的封装
 * @Author ninja
 * @Date Created on 2023/7/23
 */
public class ProxyFactoryDemo1 {
    public static void main(String[] args) {

        UserService target = new UserService();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new CustomBeforeAdvice());
        proxyFactory.addAdvice(new CustomAfterReturningAdvice());
        proxyFactory.addAdvice(new CustomThrowAdvice());
        //这个比上面实现的类有所不同，使用aop联盟的MethodInterceptor
        proxyFactory.addAdvice(new CustomAroundAdvice());

        UserService proxy = (UserService) proxyFactory.getProxy();
        proxy.test();
    }
}
