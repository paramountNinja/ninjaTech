package com.cmbchina.controller;

import com.cmbchina.remote.client.VoucherRemoteClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/1/31
 */
@RestController
public class Controller implements VoucherRemoteClient {

    @Override
    public String getVouchers(Long userId) {
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
