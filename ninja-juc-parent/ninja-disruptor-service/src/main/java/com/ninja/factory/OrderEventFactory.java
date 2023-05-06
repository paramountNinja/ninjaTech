package com.ninja.factory;

import com.ninja.domain.event.OrderEvent;
import com.lmax.disruptor.EventFactory;
import org.springframework.stereotype.Service;

/**
 * Created by ninja on 2020/1/24
 */
@Service
public class OrderEventFactory implements EventFactory<OrderEvent> {
    public OrderEvent newInstance() {
        return new OrderEvent();
    }
}
