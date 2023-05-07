package com.ninja.controller;

import com.ninja.entity.OrderVo;
import com.ninja.entity.User;
import com.ninja.entity.UserInfoVo;
import com.ninja.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/queryUserInfoById/{userId}")
    public UserInfoVo queryUserInfoById(@PathVariable("userId") Integer userId) {
        User user = userServiceImpl.queryUserById(userId);
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://ninja-provider-order-client/queryOrdersByUserId/" + userId, List.class);
        //ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://localhost:8000/queryOrdersByUserId/" + userId, List.class);
        List<OrderVo> orderVoList = responseEntity.getBody();

        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setOrderVoList(orderVoList);
        userInfoVo.setUserName(user.getUserName());
        return userInfoVo;
    }

}
