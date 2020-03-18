package com.cmbchina.service;

import org.springframework.stereotype.Service;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2020/3/18
 */
@Service
public class DemoService {

    public void check1(String a) {
        System.out.println("check 1");
    }

    public void check2(String a, String b) {
        System.out.println("check 2");
    }

    public void check3() {
        System.out.println("check 3");
    }
}
