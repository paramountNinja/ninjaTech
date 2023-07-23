package com.ninja.cglib;

import com.ninja.service.DemoService;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2023/7/23
 */
public class EnhancerDemo1 {

    public static void main(String[] args) {
        //被代理对象
        DemoService target = new DemoService();
        //代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DemoService.class);
        enhancer.setCallbacks(new Callback[]{new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                System.out.println("before...");
                //o代表的是代理对象，即enhancer，target的地方不能传入o，否则死循环,栈溢出
                Object result = methodProxy.invoke(target, objects);
                //method.invoke(target, objects); //同上
                //methodProxy.invokeSuper(target, objects);//执行被代理对象的方法，也可行
                System.out.println("after...");
                return result;
            }
        }, NoOp.INSTANCE});
        //根据方法名匹配上面的拦截数组，下标表示第几个拦截器
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                if (method.getName().equalsIgnoreCase("check1")) {
                    //使用第一个拦截器
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        DemoService demoService = (DemoService) enhancer.create();
        demoService.check1("hello world");
        demoService.check3();
    }

}
