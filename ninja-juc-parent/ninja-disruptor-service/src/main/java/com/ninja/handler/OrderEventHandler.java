package com.ninja.handler;

import com.ninja.domain.event.OrderEvent;
import com.lmax.disruptor.EventHandler;
import org.springframework.stereotype.Service;

/**
 * 消费处理
 * Created by ninja on 2020/1/24
 */
@Service
public class OrderEventHandler implements EventHandler<OrderEvent> {
    public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("消费者：" + event.getId());
    }
}
