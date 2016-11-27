package com.twiceyuan.autofinder;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by twiceYuan on 27/11/2016.
 * Email: i@twiceyuan.com
 * Site: http://twiceyuan.com
 *
 * 不自动连接 View id 的成员
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreFind {
}
