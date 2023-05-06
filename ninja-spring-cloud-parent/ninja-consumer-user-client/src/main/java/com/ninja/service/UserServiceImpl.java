package com.ninja.service;

import com.ninja.entity.User;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl {

    public User queryUserById(Integer userId) {
        return mockUser();
    }

    private User mockUser() {
        User user = new User();
        user.setUserId(676355);
        user.setUserName("ninja");
        user.setSex("man");
        return user;
    }
}
