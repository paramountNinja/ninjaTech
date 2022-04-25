package com.cmbchina.yummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getUserOrders/{userId}")
    public List<String> getUserOrders(@PathVariable("userId") String userId) {
        String url = "http://ninja-order/getOrders/" + userId;
        List<String> result = restTemplate.getForObject(url, List.class);
        return result;
    }
}
