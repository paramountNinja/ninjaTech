package com.ninja.service;

import org.springframework.stereotype.Component;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2023/7/23
 */
@Component
public class UserService implements UserInterface {
    @Override
    public void test() {
        System.out.println("test");
    }
}
