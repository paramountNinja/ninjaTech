package com.ninja.consumer.listener;

import com.ninja.contains.RabbitRelationContaints;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by ninja on 2019/12/29
 */
@Component
@Slf4j
public class RabbitReceiver {

    @RabbitListener(queues = RabbitRelationContaints.NINJA_ORDER_SUCCESS_QUEUE)
    @RabbitHandler
    public void onMessage(@Payload String orderNo,
                          Channel channel,
                          @Headers Map<String, Object> headers) throws IOException {
        log.info("消费者接收到的信息:{},当前时间:{}", orderNo, LocalDateTime.now());
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            int i = 1 / 0;
            System.out.println("processing...");
            channel.basicAck(deliveryTag, false);
            log.info("消费端ack成功:{}", deliveryTag);
        } catch (Exception e) {
            log.info("消费端NACK:{}", deliveryTag);
            channel.basicNack(deliveryTag, false, false);
        }
    }


/*    @RabbitListener(queues = "dlx_queue")
    @RabbitHandler
    public void onDlxMessage(@Payload String orderNo,
                             Channel channel,
                             @Headers Map<String, Object> headers) throws IOException {
        log.info("死信队列接收到的:{}", orderNo);
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);

    }*/
}
