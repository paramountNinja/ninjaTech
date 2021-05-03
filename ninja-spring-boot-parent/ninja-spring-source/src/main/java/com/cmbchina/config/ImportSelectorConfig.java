package com.cmbchina.config;

import com.cmbchina.po.UserPo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/4/15
 */
@Configuration
public class ImportSelectorConfig {

    @Bean
    public UserPo userPo() {
        return new UserPo("ninja", 28);
    }
}
