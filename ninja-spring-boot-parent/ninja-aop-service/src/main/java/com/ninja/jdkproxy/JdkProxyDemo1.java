package com.ninja.jdkproxy;

import com.ninja.service.UserInterface;
import com.ninja.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2023/7/23
 */
public class JdkProxyDemo1 {

    public static void main(String[] args) {
        UserService target = new UserService();

        UserInterface userInterface = (UserInterface) Proxy.newProxyInstance(JdkProxyDemo1.class.getClassLoader(), new Class[]{UserInterface.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before");
                method.invoke(target, args);
                System.out.println("after");
                return null;
            }
        });
        userInterface.test();
    }
}
