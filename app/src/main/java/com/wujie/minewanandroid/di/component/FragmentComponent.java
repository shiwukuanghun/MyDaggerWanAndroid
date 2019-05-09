package com.wujie.minewanandroid.di.component;

import com.wujie.minewanandroid.di.module.FragmentModule;
import com.wujie.minewanandroid.di.scope.FragmentScope;
import com.wujie.minewanandroid.ui.fragment.home.HomeFragment;
import com.wujie.minewanandroid.ui.fragment.knowledage.KnowledgeFragment;
import com.wujie.minewanandroid.ui.fragment.navigation.NavigationFragment;
import com.wujie.minewanandroid.ui.fragment.project.ProjectFragment;
import com.wujie.minewanandroid.ui.fragment.project.ProjectListFragment;
import com.wujie.minewanandroid.ui.fragment.todo.WaitTodoFragment;

import dagger.Component;

/**
 * Time：2019/5/5 9:58
 * Author：WuChen
 * Description：
 **/
@FragmentScope
@Component(modules = FragmentModule.class, dependencies = ApplicationComponent.class)
public interface FragmentComponent {

    void inject(HomeFragment homeFragment);
    void inject(KnowledgeFragment knowledgeFragment);
    void inject(NavigationFragment navigationFragment);
    void inject(ProjectFragment projectFragment);
    void inject(ProjectListFragment projectListFragment);
    void inject(WaitTodoFragment waitTodoFragment);

}
