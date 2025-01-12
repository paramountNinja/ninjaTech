package com.example.webflux.global;

import lombok.Builder;
import lombok.Data;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2024/12/25
 */
@Data
@Builder
public class ResultWrapper {
    private String message;
}
