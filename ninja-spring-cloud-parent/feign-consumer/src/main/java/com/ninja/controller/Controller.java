package com.ninja.controller;

import com.ninja.remote.client.OrdersRemoteClient;
import com.ninja.remote.client.User;
import com.ninja.remote.client.VoucherRemoteClient;
import com.ninja.remote.client.VoucherRemoteClient2;
import com.ninja.remote.client.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/1/31
 */
@RestController
public class Controller {

    @Autowired
    private OrdersRemoteClient ordersRemoteClient;

    @Autowired
    private VoucherRemoteClient voucherRemoteClient;

    @Autowired
    private VoucherRemoteClient2 voucherRemoteClient2;

    @GetMapping("/getOrders")
    public List<OrderVo> getOrders(Integer userId) {
        return ordersRemoteClient.queryOrdersByUserId(userId);
    }

    @GetMapping("/getUserVouchers")
    public String getVouchers(Long userId) {
        return voucherRemoteClient.getVouchers(userId);
    }

    @GetMapping("/getUserVouchers2")
    public String getVouchers2(Long userId) {
        return voucherRemoteClient2.getVouchers2(String.valueOf(userId));
    }

    @GetMapping("/getUserVouchers3")
    public String getVouchers3(Long userId) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.put("userId", Collections.singletonList(String.valueOf(userId)));
        return voucherRemoteClient2.getVouchers3(map);
    }

    @GetMapping("/getUserVouchers4")
    public String getVouchers4(Long userId) {
        User user = new User();
        user.setName("zhangsan");
        return voucherRemoteClient2.getVouchers4(user);
    }
}
