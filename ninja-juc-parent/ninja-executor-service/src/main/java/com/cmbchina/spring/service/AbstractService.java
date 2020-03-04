package com.cmbchina.spring.service;

import org.springframework.scheduling.annotation.Async;

/**
 * Created by ninja on 2020/2/10
 */
@Async("threadPoolInstance")
public abstract class AbstractService {
    public void handle() {
        invoke();
    }

    public abstract void invoke();
}
