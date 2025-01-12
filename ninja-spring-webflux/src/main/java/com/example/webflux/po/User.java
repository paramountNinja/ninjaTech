package com.example.webflux.po;

import lombok.Builder;
import lombok.Data;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2024/12/24
 */
@Data
@Builder
public class User {
    private Integer id;
    private String name;
}
