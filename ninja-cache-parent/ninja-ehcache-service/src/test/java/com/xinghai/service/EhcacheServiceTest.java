package com.xinghai.service;

import com.xinghai.EhcacheApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2023/7/22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EhcacheApplication.class)
@SpringBootTest
public class EhcacheServiceTest {

    @Autowired
    private EhcacheService ehcacheService;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void setup() {

    }

    @Test
    public void testCachedData() throws InterruptedException {

        Cache myCache = cacheManager.getCache("myCache");


        String messi1 = ehcacheService.getCachedData("messi1");
        System.out.println(messi1);

        System.out.println("==================");

        String messi11 = ehcacheService.getCachedData("messi1");
        System.out.println(messi11);


        Object value = myCache.get("messi1").get();
        System.out.println(value);

        Thread.sleep(6000);

        ehcacheService.getCachedData("messi1");
        //myCache = cacheManager.getCache("myCache");
        //value = myCache.get("messi1").get();
        //System.out.println("result: "+value);
    }
}
