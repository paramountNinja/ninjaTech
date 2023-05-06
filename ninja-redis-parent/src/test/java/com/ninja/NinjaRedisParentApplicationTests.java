package com.ninja;

import com.ninja.hystrix.HystrixDemo1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
class NinjaRedisParentApplicationTests {

    private static int index = 0;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private HystrixDemo1 hystrixDemo1;

    @Test
    void contextLoads() throws InterruptedException {
        String key = "code:set";
        int maxSiz = 100;

        while (true) {
            if (stringRedisTemplate.opsForSet().size(key) > maxSiz) {
                Thread.sleep(2000);
                continue;
            }

            Set<String> set = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                set.add(String.valueOf(index));
                index++;
            }

            String[] codeStrings = new String[set.size()];
            set.toArray(codeStrings);
            stringRedisTemplate.opsForSet().add(key, codeStrings);
        }
    }

    @Test
    void test1() throws InterruptedException {
        String key = "code:set";
        //Set<String> strings = stringRedisTemplate.opsForSet().distinctRandomMembers(key, 3);
        long startTime = System.currentTimeMillis();
        try {
            List<String> pop = stringRedisTemplate.opsForSet().pop(key, 5);
            System.out.println(pop);
        } catch (Exception ex) {
            log.error("error:", ex);
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("process time:" + (endTime - startTime));
        }
    }

    @Test
    void test2() throws InterruptedException {

        stringRedisTemplate.executePipelined(new SessionCallback<Object>() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                operations.opsForValue().set("A", "a");
                doThrowEx();
                operations.opsForValue().set("B", "b");
                operations.opsForValue().set("C", "c");
                operations.exec();
                return null;
            }
        });
    }

    @Test
    void test3() throws InterruptedException {
        stringRedisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set("D".getBytes(StandardCharsets.UTF_8), "d".getBytes(StandardCharsets.UTF_8));
                doThrowEx();
                connection.set("E".getBytes(StandardCharsets.UTF_8), "e".getBytes(StandardCharsets.UTF_8));
                connection.set("F".getBytes(StandardCharsets.UTF_8), "f".getBytes(StandardCharsets.UTF_8));
                return null;
            }
        });
    }

    @Test
    void test4() throws InterruptedException {
        stringRedisTemplate.opsForList().leftPushAll("code.que", "a", "b", "c", "d");
        stringRedisTemplate.opsForList().leftPop("code.que", 0, TimeUnit.SECONDS);
    }

    @Test
    void test5() {
        System.out.println("测试结果：" + hystrixDemo1.service(1,"hello param"));
    }

    @Test
    void test6() {
        List<Object> list = stringRedisTemplate.executePipelined(new SessionCallback<String>() {
            @Override
            public String execute(RedisOperations operations) throws DataAccessException {
                for (int i = 0; i < 100; i++) {
                    operations.opsForSet().pop("code:set");
                }
                return null;
            }
        });
        System.out.println(list);
    }

    private void doThrowEx() {
        throw new RuntimeException();
    }
}
