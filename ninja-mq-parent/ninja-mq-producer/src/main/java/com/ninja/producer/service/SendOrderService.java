package com.ninja.producer.service;

import com.ninja.contains.RabbitRelationContaints;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ninja on 2019/12/7
 */
@Service
@Slf4j
public class SendOrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final RabbitTemplate.ConfirmCallback confirmCallback =
            (correlationData, ack, cause) -> {
                //System.out.println("confirmCallback step");
                if (ack) {
                    log.info("消息成功发送到mq,订单号orderNo:{}", correlationData.getId());
                } else {
                    log.error("消息未成功发送到mq,订单号ordrNo:{}", correlationData.getId());
                }
            };

    public void handle(String orderNo) {
        CorrelationData correlationData = new CorrelationData(orderNo);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.convertAndSend(
                RabbitRelationContaints.NINJA_EXCHANGE_01,
                RabbitRelationContaints.ORDER_TOPIC_KEY,
                orderNo, correlationData);
    }
}
