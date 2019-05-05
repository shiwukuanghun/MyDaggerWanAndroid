package com.wujie.minewanandroid.di.component;

import com.wujie.minewanandroid.di.module.ActivityModule;
import com.wujie.minewanandroid.di.scope.ActivityScope;
import com.wujie.minewanandroid.ui.activity.login.LoginActivity;
import com.wujie.minewanandroid.ui.activity.register.RegisterActivity;

import dagger.Component;

/**
 * Time：2019/5/5 9:57
 * Author：WuChen
 * Description：
 **/
@ActivityScope
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    void inject(LoginActivity loginActivity);
    void inject(RegisterActivity registerActivity);
}
