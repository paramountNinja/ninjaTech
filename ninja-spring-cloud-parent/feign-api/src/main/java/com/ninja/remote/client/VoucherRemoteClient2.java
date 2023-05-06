package com.ninja.remote.client;

import com.ninja.remote.config.CustomFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2022/4/25
 */
@FeignClient(name = "feign-provider", configuration = CustomFeignConfig.class)
public interface VoucherRemoteClient2 {
    @RequestMapping(value = "/xxx", method = RequestMethod.POST
            //, consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    String getVouchers2(String str);

    @RequestMapping(value = "/yyy", method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String getVouchers3(MultiValueMap<String, Object> map);

    @RequestMapping(value = "/zzz", method = RequestMethod.POST
            //, consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    String getVouchers4(@RequestBody User user);

}
