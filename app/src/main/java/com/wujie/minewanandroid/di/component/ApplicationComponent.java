package com.wujie.minewanandroid.di.component;

import android.app.Application;

import com.wujie.minewanandroid.data.DataManager;
import com.wujie.minewanandroid.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Time：2019/5/5 9:42
 * Author：WuChen
 * Description：
 **/
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Application getApplication();
    DataManager dataManager();
}
