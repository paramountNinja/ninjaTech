package com.ninja;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;


/**
 * @Desc
 * @Author ninja
 * @Date Created on 2023/5/9
 */
@SpringBootTest
@Slf4j
public class JudgeRedisSuccessTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Test
    public void test() throws Exception {
        //stringRedisTemplate.opsForValue().decrement("stock");
        decrementStock();
    }


    public void decrementStock() {
        RedisConnection connection = redisConnectionFactory.getConnection();
        connection.watch("stock".getBytes());
        Integer stock = Integer.valueOf(new String(connection.get("stock".getBytes())));
        if (stock != null && stock > 0) {
            connection.multi();
            connection.decr("stock".getBytes());
            List<Object> results = connection.exec();
            if (results.isEmpty()) {
                throw new RuntimeException("Failed to update stock due to concurrency issue");
            }
        } else if (stock == null) {
            throw new RuntimeException("Stock does not exist");
        } else {
            throw new RuntimeException("Out of stock");
        }
    }


    /*public void decrementStock(RedisTemplate<String, Integer> redisTemplate) {
        redisTemplate.execute(new SessionCallback<Object>() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                operations.watch("stock");
                Integer stock = (Integer) operations.opsForValue().get("stock");
                if (stock != null && stock > 0) {
                    operations.multi();
                    operations.opsForValue().decrement("stock");
                    List results = operations.exec();
                    if (results.isEmpty()) {
                        throw new RuntimeException("Failed to update stock due to concurrency issue");
                    }
                } else if (stock == null) {
                    throw new RuntimeException("Stock does not exist");
                } else {
                    throw new RuntimeException("Out of stock");
                }
                return null;
            }
        });
    }*/

}
