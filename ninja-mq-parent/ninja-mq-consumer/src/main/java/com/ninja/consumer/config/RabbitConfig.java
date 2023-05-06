package com.ninja.consumer.config;

import com.ninja.contains.RabbitRelationContaints;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ninja on 2019/12/7
 */
@Configuration
public class RabbitConfig {


    @Bean
    public TopicExchange exchange01() {
        return new TopicExchange(RabbitRelationContaints.NINJA_EXCHANGE_01, true, false);
    }

    @Bean
    public TopicExchange dlxExchange() {
        return new TopicExchange("dlx_exchange", true, false);
    }

    @Bean
    public Queue orderSuccessQueue() {
        Map<String, Object> args = new HashMap<>(16);
        args.put("x-dead-letter-exchange", "dlx_exchange");
        return QueueBuilder
                .durable(RabbitRelationContaints.NINJA_ORDER_SUCCESS_QUEUE)
                .withArguments(args)
                .build();
    }

    @Bean
    public Queue dlxQueue() {
        Map<String, Object> args = new HashMap<>(16);
        args.put("x-dead-letter-exchange", RabbitRelationContaints.NINJA_EXCHANGE_01);
        args.put("x-dead-letter-routing-key", "actual.consume.queue");
        args.put("x-message-ttl", 5000);
        return QueueBuilder
                .durable("dlx_queue")
                .withArguments(args)
                .build();
    }

    @Bean
    public Queue actualConsumeQueue() {
        return QueueBuilder
                .durable("actual_queue")
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

    @Bean
    public Binding actualBinding() {
        return BindingBuilder
                .bind(actualConsumeQueue())
                .to(exchange01())
                .with("actual.consume.queue");
    }


    /*

    @Bean
    public TopicExchange exchange01() {
        return new TopicExchange(RabbitRelationContaints.NINJA_EXCHANGE_01, true, false);
    }

    @Bean
    public Queue orderSuccessQueue() {
        return new Queue(RabbitRelationContaints.NINJA_ORDER_SUCCESS_QUEUE, true);
    }

    @Bean
    public Queue orderFailQueue() {
        return new Queue(RabbitRelationContaints.NINJA_ORDER_FAIL_QUEUE, true);
    }



    @Bean
    public Binding orderFailBinding() {
        return BindingBuilder
                .bind(orderFailQueue())
                .to(exchange01())
                .with(RabbitRelationContaints.ORDER_FAIL_BIINDING_KEY);
    }*/
}
