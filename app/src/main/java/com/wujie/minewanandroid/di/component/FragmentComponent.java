package com.wujie.minewanandroid.di.component;

import com.wujie.minewanandroid.di.module.FragmentModule;
import com.wujie.minewanandroid.di.scope.FragmentScope;

import dagger.Component;

/**
 * Time：2019/5/5 9:58
 * Author：WuChen
 * Description：
 **/
@FragmentScope
@Component(modules = FragmentModule.class, dependencies = ApplicationComponent.class)
public interface FragmentComponent {
}
