package com.ninja.web.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2020/3/4
 */
@Data
public class DemoRequest {

    //不能为null
    @NotNull
    private String chnlId;

    //不能为null,且必须有一个非空字符
    @NotBlank
    private String chnlUserId;

    @NotNull
    private Integer credits;
}
