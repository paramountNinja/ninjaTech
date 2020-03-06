package com.cmbchina.service;

import com.cmbchina.vo.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2020/3/5
 */
public class MemberServiceTest {
    @Mock
    UserService userService;
    @InjectMocks
    MemberService memberService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMembers() throws Exception {
        when(userService.getUsers()).thenReturn(Arrays.<User>asList(new User("name", 0)));

        List<User> result = memberService.getMembers();
        Assert.assertEquals(Arrays.<User>asList(new User("name", 0)), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme