package com.cmbchina.applicationevent;

import org.springframework.context.ApplicationEvent;

/**
 * 观察者目标类  事件
 *
 * @Desc
 * @Author ninja
 * @Date Created on 2021/4/15
 */
public class JavaStackEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public JavaStackEvent(Object source) {
        super(source);
    }
}
