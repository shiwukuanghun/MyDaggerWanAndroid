package com.wujie.minewanandroid.ui.fragment.todo;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wujie.minewanandroid.R;
import com.wujie.minewanandroid.presenter.BasePresenter;
import com.wujie.minewanandroid.ui.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Time：2019/1/23 0023 下午 15:15
 * Author：WuChen
 * Description：
 **/
public class CompleteTodoFragment extends BaseFragment {
    @BindView(R.id.rv_todo)
    RecyclerView mRvTodo;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wait_todo;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

}
