package com.cmbchina.importselector;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/4/15
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Import(SpringStudySelector.class)
public @interface EnableSpringStudy {
}
