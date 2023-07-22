package com.ninja.config;

import com.ninja.aspect.NinjaInterceptor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/4/14
 */
@Configuration
public class InterceptorConfig {

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        NinjaInterceptor ninjaInterceptor = new NinjaInterceptor();
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.xinghai..service..*Service.*(..))");

        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(ninjaInterceptor);
        return advisor;
    }
}
