package com.ninja.demo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2022/12/24
 */
public class HystrixCommandDemo1 extends HystrixCommand<Object> {

    public HystrixCommandDemo1(String commandGroupKey) {
        super(HystrixCommandGroupKey.Factory.asKey(commandGroupKey));
    }

    @Override
    protected Object run() throws Exception {
        //远程调用等实现
        //Thread.sleep(1000);
        throw new RuntimeException();
        //return "run";
    }

    @Override
    protected Object getFallback() {
        return "fallback";
        //return super.getFallback();
    }

    public static void main(String[] args) {
        HystrixCommandDemo1 hystrixCommandDemo1 = new HystrixCommandDemo1("groupKey");
        Object res = hystrixCommandDemo1.execute();
        System.out.println(res);
    }


}
