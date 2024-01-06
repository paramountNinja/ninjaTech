package com.ninja.controller;

import com.ninja.remote.client.VoucherRemoteClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/1/31
 */
@RestController
public class Controller implements VoucherRemoteClient {

    static Logger logger = LoggerFactory.getLogger(Controller.class);

    @Override
    public String getVouchers(Long userId) {

        logger.info("开始模拟生成userID");

        if (userId == 1) {
            try {
                //int sleepTime = new Random().nextInt(2000);
                int sleepTime = 2001;
                System.out.println(sleepTime);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return userId + ":" + UUID.randomUUID().toString();
    }
}
