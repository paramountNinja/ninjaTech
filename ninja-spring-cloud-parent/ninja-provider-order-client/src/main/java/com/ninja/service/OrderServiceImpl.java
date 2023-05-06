package com.ninja.service;

import java.math.BigDecimal;

import com.ninja.entity.Order;
import com.ninja.entity.OrderVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by smlz on 2019/3/26.
 */
@Service
public class OrderServiceImpl {

    public List<OrderVo> queryOrdersByUserId(Integer userId) {
        List<Order> orderList = mockOrderList(userId);
        List<OrderVo> orderVoList = new ArrayList<>();
        for (Order order : orderList) {
            OrderVo orderVo = new OrderVo();
            BeanUtils.copyProperties(order, orderVo);
            orderVoList.add(orderVo);
        }
        return orderVoList;
    }

    private List<Order> mockOrderList(Integer userId) {
        List<Order> orderList = new ArrayList<>();
        Order order1 = new Order();
        order1.setOrderId(2020020801);
        order1.setOrderMoney(new BigDecimal("100.00"));
        order1.setUserId(676355);
        order1.setCreateDt(new Date());

        Order order2 = new Order();
        order2.setOrderId(2020020802);
        order2.setOrderMoney(new BigDecimal("200.00"));
        order2.setUserId(676355);
        order2.setCreateDt(new Date());

        orderList.add(order1);
        orderList.add(order2);

        return orderList;
    }
}
