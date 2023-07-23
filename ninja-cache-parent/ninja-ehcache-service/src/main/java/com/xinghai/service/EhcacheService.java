package com.xinghai.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Desc ehcache service
 * @Author ninja
 * @Date Created on 2023/7/22
 */
@Service
public class EhcacheService {
    @Cacheable("myCache")
    public String getCachedData(String key) {
        System.out.println("execute actual method");
        // 从数据库或其他数据源获取数据的逻辑
        return "someData";
    }
}
