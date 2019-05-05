package com.wujie.minewanandroid.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Time：2019/5/5 9:39
 * Author：WuChen
 * Description：
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface ActivityScope {
}
