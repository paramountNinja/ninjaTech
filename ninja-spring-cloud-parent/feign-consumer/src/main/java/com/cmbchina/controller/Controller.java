package com.cmbchina.controller;

import com.cmbchina.remote.client.OrdersRemoteClient;
import com.cmbchina.remote.client.VoucherRemoteClient;
import com.cmbchina.remote.client.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getOrders")
    public List<OrderVo> getOrders(Integer userId) {
        return ordersRemoteClient.queryOrdersByUserId(userId);
    }

    @GetMapping("/getUserVouchers")
    public String getVouchers(Long userId) {
        return voucherRemoteClient.getVouchers(userId);
    }
}
