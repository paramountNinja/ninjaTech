/*
package com.xinghai.consumer.config;

import com.xinghai.contains.RabbitRelationContaints;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

*/
/**
 * Created by ninja on 2019/12/30
 *//*

@Configuration
public class RabbitConfig1 {

    @Bean
    public TopicExchange normalExchange() {
        return new TopicExchange("normal.exchange", true, false);
    }

    @Bean
    public TopicExchange retryExchange() {
        return new TopicExchange("retry_exchange", true, false);
    }

    @Bean
    public TopicExchange failExchange() {
        return new TopicExchange("fail_exchange", true, false);
    }

    @Bean
    public Queue normalQueue() {
        return QueueBuilder
                .durable("normal.queue")
                .build();
    }

    @Bean
    public Queue retryQueue() {
        Map<String, Object> args = new HashMap<>(16);
        args.put("x-dead-letter-exchange", "");
        return QueueBuilder
                .durable("dlx_queue")
                .build();
    }

    @Bean
    public Binding orderSuccessBinding() {
        return BindingBuilder
                .bind(orderSuccessQueue())
                .to(exchange01())
                .with(RabbitRelationContaints.ORDER_SUCCESS_BIINDING_KEY);
    }


    @Bean
    public Binding dlxBinding() {
        return BindingBuilder
                .bind(dlxQueue())
                .to(dlxExchange())
                .with("#");
    }
}
*/
