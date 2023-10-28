package com.ninja.dto;

import lombok.Data;

import java.util.List;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2023/10/25
 */
@Data
public class UserInfo {
    private String name;

    private List<SchoolInfo> schoolInfos;
}
