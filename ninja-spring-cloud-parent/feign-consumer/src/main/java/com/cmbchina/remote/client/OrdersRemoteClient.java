package com.cmbchina.remote.client;

import com.cmbchina.remote.client.vo.OrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/1/31
 */
@FeignClient(name = "ninja-provider-order-client")
public interface OrdersRemoteClient {

    @RequestMapping("/queryOrdersByUserId/{userId}")
    public List<OrderVo> queryOrdersByUserId(@PathVariable(value = "userId") Integer userId);
}
