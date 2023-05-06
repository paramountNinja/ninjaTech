package com.ninja.vo;

import lombok.extern.slf4j.Slf4j;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/4/11
 */
@Slf4j
public class Administrator {
    private String num;

    public Administrator(String num) {
        log.info("一次构造");
        this.num = num;
    }
}
