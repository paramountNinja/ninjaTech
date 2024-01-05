package com.ninja.jdbc;

import com.ninja.jdbc.mapper.CustomersMapper;
import com.ninja.jdbc.po.Customers;
import com.ninja.jdbc.po.CustomersExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NinjaJdbcApplicationTests {

    @Autowired
    CustomersMapper customersMapper;

    @Test
    public void contextLoads() {
        CustomersExample example = new CustomersExample();
        List<Customers> customers = customersMapper.selectByExample(example);
        System.out.println(customers);
    }

}
