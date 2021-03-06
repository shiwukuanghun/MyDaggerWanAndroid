package com.wujie.minewanandroid.ui.activity.todo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wujie.minewanandroid.BaseActivity;
import com.wujie.minewanandroid.R;
import com.wujie.minewanandroid.adapter.TodoPageAdapter;
import com.wujie.minewanandroid.util.ARouterUtils;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Time：2019/1/21 0021 下午 15:21
 * Author：WuChen
 * Description：todo界面
 **/
@Route(path = ARouterUtils.TodoPath)
public class TodoActivity extends BaseActivity {

    private String[] mTitles = {"待办", "已完成"};

    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_add_icon)
    ImageView mIvAddIcon;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp_todo)
    ViewPager mVpTodo;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_todo;
    }

    @Override
    protected void init() {
//        ImmersionBar.with(this)
//                .transparentStatusBar()
//                .statusBarView(R.id.view)
//                .init();
        TodoPageAdapter todoPageAdapter= new TodoPageAdapter(getSupportFragmentManager(), mTitles);
        mVpTodo.setAdapter(todoPageAdapter);
        mTab.setupWithViewPager(mVpTodo);
    }

    @OnClick(R.id.iv_add_icon)
    public void onViewClicked() {
        ARouter.getInstance().build(ARouterUtils.AddTodoPath).navigation();
    }

}
