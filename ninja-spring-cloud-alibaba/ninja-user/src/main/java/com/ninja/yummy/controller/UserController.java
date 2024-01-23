package com.ninja.yummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/5/4
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplate restTemplateNoLoadBalanced;

    @GetMapping("/getUserOrders/{userId}")
    public List<String> getUserOrders(@PathVariable("userId") String userId) {
        String url = "http://ninja-order/getOrders/" + userId;
        List<String> result = restTemplate.getForObject(url, List.class);
        return result;
    }

    //=====以下写法很麻烦，可以使用@LoadBalanced注解替换，参加上面=========


    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/getUserOrders2/{userId}")
    public List<String> getUserOrders2(@PathVariable("userId") String userId) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("ninja-order");
        String url = String.format("http://%s:%s/getOrders/%s",
                serviceInstance.getHost(), serviceInstance.getPort(), userId);

        List<String> result2 = restTemplateNoLoadBalanced.getForObject(url, List.class);
        return result2;
    }

}
