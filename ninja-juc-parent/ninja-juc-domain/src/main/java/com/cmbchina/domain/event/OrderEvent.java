package com.cmbchina.domain.event;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by ninja on 2020/1/24
 */

@Data
public class OrderEvent {
    private long id;

    private BigDecimal totalAmount;
}
