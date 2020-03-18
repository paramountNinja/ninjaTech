package com.cmbchina.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2020/3/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoServiceTest {
    @Autowired
    private DemoService demoService;

    @Value("${name}")
    public String name;

    @Test
    public void testCheck1() throws Exception {
        demoService.check1("check1-param1");
        demoService.check2("check2-param1", "check2-param2");
        demoService.check3();
    }

    @Test
    public void testProperties() {
        System.out.println(name);
    }

}

