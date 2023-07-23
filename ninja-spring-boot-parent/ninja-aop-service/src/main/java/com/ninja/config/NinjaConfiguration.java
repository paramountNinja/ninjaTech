package com.ninja.config;

import com.ninja.advice.CustomBeforeAdvice;
import com.ninja.service.UserService;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.*;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/4/14
 */
@Configuration
@ComponentScan(basePackages = {"com.ninja"})
//@Import(DefaultAdvisorAutoProxyCreator.class) //自动导入,只会找advisor
//@EnableAspectJAutoProxy //实际为了导入AnnotationAwareAspectJAutoProxyCreator,负责解析@Aspect
public class NinjaConfiguration {

    //创建一个被代理的bean
    //@Bean
    public ProxyFactoryBean proxyFactoryBean() {
        UserService target = new UserService();
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(target);
        proxyFactoryBean.addAdvice(new CustomBeforeAdvice());

        return proxyFactoryBean;
    }

    //指定代理的规则，需要target和advice均被spring托管
    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("userSe*");
        beanNameAutoProxyCreator.setInterceptorNames("customBeforeAdvice");
        beanNameAutoProxyCreator.setProxyTargetClass(true);

        return beanNameAutoProxyCreator;
    }


    //找出所有adivisor的bean,比beanNameAutoProxyCreator更牛逼
    //@Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        return defaultAdvisorAutoProxyCreator;
    }

}
