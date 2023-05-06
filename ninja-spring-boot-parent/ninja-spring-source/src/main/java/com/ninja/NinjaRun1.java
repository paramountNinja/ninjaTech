package com.ninja;

import com.ninja.importselector.EnableSpringStudy;
import com.ninja.po.UserPo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/4/15
 */

public class NinjaRun1 {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SelectorConfig.class);
        UserPo userPo = (UserPo) context.getBean("userPo");
        System.out.println(userPo.getName() + ":" + userPo.getAge());
    }
}

@Configuration
@EnableSpringStudy
class SelectorConfig {

}
