package com.ninja.applicationevent.trade;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/4/15
 */
@RequiredArgsConstructor
public class OrderApplicationListener implements ApplicationListener<OrderEvent> {

    @NonNull
    private String scene;

    @Override
    public void onApplicationEvent(OrderEvent event) {

    }
}
