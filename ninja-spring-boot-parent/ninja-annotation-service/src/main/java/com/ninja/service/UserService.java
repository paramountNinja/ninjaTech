package com.ninja.service;

import com.ninja.vo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2020/3/5
 */
@Service
public class UserService {

    public List<User> getUsers() {
        List<User> list = new ArrayList();
        list.add(new User("james", 33));
        list.add(new User("ninja", 27));
        return list;
    }
}
