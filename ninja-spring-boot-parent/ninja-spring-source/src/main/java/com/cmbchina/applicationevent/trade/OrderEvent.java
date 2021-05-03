package com.cmbchina.applicationevent.trade;

import org.springframework.context.ApplicationEvent;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/4/15
 */
public class OrderEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public OrderEvent(Object source) {
        super(source);
    }
}
