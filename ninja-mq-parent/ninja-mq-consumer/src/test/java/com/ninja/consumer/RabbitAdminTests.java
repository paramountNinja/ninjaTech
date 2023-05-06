package com.ninja.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

//spring环境？
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitAdminTests {

    @Test
    public void contextLoads() {
    }


    @Autowired
    private RabbitAdmin rabbitAdmin;

    /**
     * RabbitAdmin用户申明rabbit的元素，即常用操作
     */
    @Test
    public void testRabbitAdmin() {
        //durable=false 服务重启路由失效
        rabbitAdmin.declareExchange(new DirectExchange("test.direct", false, false));
        rabbitAdmin.declareExchange(new TopicExchange("test.topic", false, false));
        rabbitAdmin.declareExchange(new FanoutExchange("test.fanout", false, false));

        rabbitAdmin.declareQueue(new Queue("test.direct.queue", false));
        rabbitAdmin.declareQueue(new Queue("test.topic.queue", false));
        rabbitAdmin.declareQueue(new Queue("test.fanout.queue", false));

        rabbitAdmin.declareBinding(new Binding(
                "test.direct.queue",
                Binding.DestinationType.QUEUE,
                "test.direct",
                "direct_key",
                new HashMap<>()));

        rabbitAdmin.declareBinding(BindingBuilder
                .bind(new Queue("test.topic.queue", false))
                .to(new TopicExchange("test.topic", false, false))
                .with("user.#"));

        rabbitAdmin.declareBinding(BindingBuilder
                .bind(new Queue("test.fanout.queue", false))
                .to(new FanoutExchange("test.fanout", false, false)));

        //清空队列数据
        rabbitAdmin.purgeQueue("test.topic.queue", false);

    }

}
