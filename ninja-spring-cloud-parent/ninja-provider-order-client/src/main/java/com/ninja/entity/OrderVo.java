package com.ninja.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by smlz on 2019/3/26.
 */
@Data
public class OrderVo {

    private Integer orderId;

    private BigDecimal orderMoney;

    private Integer userId;
}
