package com.cmbchina.remote.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/1/31
 */
@FeignClient(name = "feign-provider")
public interface VoucherRemoteClient {

    @RequestMapping(value = "/getVouchers", method = RequestMethod.GET)
    String getVouchers(@RequestParam("userId") Long userId);
}
