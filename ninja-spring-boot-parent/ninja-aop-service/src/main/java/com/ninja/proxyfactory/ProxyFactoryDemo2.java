package com.ninja.proxyfactory;

import com.ninja.advice.CustomBeforeAdvice;
import com.ninja.service.UserService;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @Desc spring 对aop的封装
 * @Author ninja
 * @Date Created on 2023/7/23
 */
public class ProxyFactoryDemo2 {
    public static void main(String[] args) {

        UserService target = new UserService();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        //advisor = advice + pointcut
        proxyFactory.addAdvisor(new PointcutAdvisor() {
            @Override
            public Pointcut getPointcut() {
                return new StaticMethodMatcherPointcut() {
                    @Override
                    public boolean matches(Method method, Class<?> targetClass) {
                        return method.getName().equalsIgnoreCase("test");
                    }
                };
            }

            @Override
            public Advice getAdvice() {
                return new CustomBeforeAdvice();
            }

            @Override
            public boolean isPerInstance() {
                return false;
            }
        });

        UserService proxy = (UserService) proxyFactory.getProxy();
        proxy.test();
    }
}
