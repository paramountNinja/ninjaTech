package com.cmbchina.producer;

import com.cmbchina.domain.event.OrderEvent;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by ninja on 2020/1/24
 */
public class OrderEventProducer {

    private RingBuffer<OrderEvent> ringBuffer;

    public OrderEventProducer(RingBuffer<OrderEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void sendData(ByteBuffer data) {
        long sequence = ringBuffer.next();
        try {
            OrderEvent event = ringBuffer.get(sequence);
            event.setId(data.getLong(0));
        } finally {
            ringBuffer.publish(sequence);
        }

    }
}

