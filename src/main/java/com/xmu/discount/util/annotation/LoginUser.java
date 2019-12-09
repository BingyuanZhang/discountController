package com.xmu.discount.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解-验证是否登录
 * @author Zhang Bingyuan
 */
//定义注解使用于参数上
@Target(ElementType.PARAMETER)
//定义注解在运行时生效
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}