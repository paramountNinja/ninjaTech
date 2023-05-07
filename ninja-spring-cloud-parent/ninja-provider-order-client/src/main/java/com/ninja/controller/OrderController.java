package com.ninja.controller;

import com.ninja.entity.OrderVo;
import com.ninja.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @RequestMapping("/queryOrdersByUserId/{userId}")
    public List<OrderVo> queryOrdersByUserId(@PathVariable("userId") Integer userId) {
        return orderServiceImpl.queryOrdersByUserId(userId);
    }

    @RequestMapping("/order/test")
    public String test(){
        return "ok";
    }
}
