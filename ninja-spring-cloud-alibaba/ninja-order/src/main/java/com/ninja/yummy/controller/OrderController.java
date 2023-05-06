package com.ninja.yummy.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/5/4
 */
@RestController
public class OrderController {

    @RequestMapping("/getOrders/{userId}")
    public List<String> getOrders(@PathVariable("userId") String userId) {
        List<String> result = new ArrayList<>();
        result.add("202105040001");
        result.add("202105040002");
        result.add("202105040003");
        return result;
    }
}
