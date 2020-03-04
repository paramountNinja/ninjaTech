package com.cmbchina;

import com.cmbchina.domain.event.OrderEvent;
import com.cmbchina.factory.OrderEventFactory;
import com.cmbchina.handler.OrderEventHandler;
import com.cmbchina.producer.OrderEventProducer;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ninja on 2020/1/24
 */
public class Main {
    public static void main(String[] args) {

        OrderEventFactory orderEventFactory = new OrderEventFactory();
        int ringBufferSize = 1024 * 1024;
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Disruptor<OrderEvent> disruptor = new Disruptor<OrderEvent>(
                orderEventFactory,
                ringBufferSize,
                //使用ThreadPoolExecutor自定义线程池
                executorService,
                //单生产者模型
                ProducerType.SINGLE,

                //等待策略
                new BlockingWaitStrategy()
        );

        //添加消费者的监听
        disruptor.handleEventsWith(new OrderEventHandler());

        //启动
        disruptor.start();

        //获取实际存储数据的容器 RingBuffer
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();

        OrderEventProducer orderEventProducer = new OrderEventProducer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long i = 0; i < 100; i++) {
            bb.putLong(0, i);
            orderEventProducer.sendData(bb);
        }

        disruptor.shutdown();
        executorService.shutdown();

    }
}
