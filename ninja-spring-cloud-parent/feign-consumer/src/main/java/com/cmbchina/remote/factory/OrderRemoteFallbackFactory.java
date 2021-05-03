package com.cmbchina.remote.factory;

import com.cmbchina.remote.client.OrdersRemoteClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/2/6
 */
@Component
@Slf4j
public class OrderRemoteFallbackFactory implements FallbackFactory<OrdersRemoteClient> {
    //lambda表达式
    @Override
    public OrdersRemoteClient create(Throwable throwable) {
        return userId -> null;
    }

    /*@Override
    public OrdersRemoteClient create(Throwable throwable) {
        return new OrdersRemoteClient() {
            @Override
            public List<OrderVo> queryOrdersByUserId(Integer userId) {
                return null;
            }
        };
    }*/

    public static void main(String[] args) {
        RestTemplateCustomizer restTemplateCustomizer = restTemplate -> {
            List<ClientHttpRequestInterceptor> list = new ArrayList<>(
                    restTemplate.getInterceptors());
            System.out.println(restTemplate);
            restTemplate.setInterceptors(list);
        };

        /*RestTemplateCustomizer restTemplateCustomizer = new RestTemplateCustomizer() {
            @Override
            public void customize(RestTemplate restTemplate) {
                List<ClientHttpRequestInterceptor> list = new ArrayList<>(
                        restTemplate.getInterceptors());
                restTemplate.setInterceptors(list);
            }
        };*/
        restTemplateCustomizer.customize(new RestTemplate());
    }
}
