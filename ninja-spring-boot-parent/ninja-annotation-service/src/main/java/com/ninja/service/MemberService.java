package com.ninja.service;

import com.ninja.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2020/3/5
 */
@Service
public class MemberService {
    @Autowired
    private UserService userService;

    public List<User> getMembers() {
        return userService.getUsers();
    }
}
