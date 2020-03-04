package com.cmbchina;

import com.cmbchina.spring.service.Demo2Service;
import com.cmbchina.spring.service.Demo3Service;
import com.cmbchina.spring.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NinjaExecutorServiceApplicationTests {
    @Autowired
    private DemoService demoService;

    @Autowired
    private Demo2Service demo2Service;

    @Autowired
    private Demo3Service demo3Service;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            demoService.handle();
            //System.out.println("当前线程执行完毕");
        }
    }

    @Test
    public void test2() {
        for (int i = 0; i < 10; i++) {
            demo2Service.handle();
        }
    }

    @Test
    public void test3() {
        for (int i = 0; i < 10; i++) {
            demo3Service.handle();
        }
    }


}
