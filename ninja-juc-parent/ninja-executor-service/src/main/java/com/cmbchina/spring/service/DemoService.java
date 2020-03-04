package com.cmbchina.spring.service;

import com.cmbchina.base.executors.RunTask;
import com.cmbchina.spring.config.ThreadPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

/**
 *{@link ThreadPoolConfig#createExecutorServiceInstance()}
 * Created by ninja on 2020/1/30
 */
@Service
public class DemoService {

    @Autowired
    private RunTask runTask;

    @Resource(name = "threadPoolInstance")
    private ExecutorService executorService;

    public void handle() {
        executorService.execute(runTask);
    }
}
