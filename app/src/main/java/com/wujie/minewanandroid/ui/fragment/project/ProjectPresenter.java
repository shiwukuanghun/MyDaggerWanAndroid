package com.wujie.minewanandroid.ui.fragment.project;

import com.wujie.minewanandroid.bean.ProjectTypeBean;
import com.wujie.minewanandroid.data.DataManager;
import com.wujie.minewanandroid.http.BaseObserver;
import com.wujie.minewanandroid.http.RxRetrofit;
import com.wujie.minewanandroid.presenter.BasePresenter;
import com.wujie.minewanandroid.util.RxHelper;

import java.util.List;

import javax.inject.Inject;

/**
 * Time：2019/1/14 0014 下午 17:38
 * Author：WuChen
 * Description：
 **/
public class ProjectPresenter extends BasePresenter<ProjectContact.View> implements ProjectContact.Presenter {

    private DataManager mDataManager;

    @Inject
    public ProjectPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void getProjectType() {
        addDisposable(mDataManager.getProjectType()
                .compose(RxHelper.rxSchedulderHelper())
                .compose(RxHelper.handleResult2())
                .subscribeWith(new BaseObserver<List<ProjectTypeBean>>() {
                    @Override
                    protected void start() {

                    }

                    @Override
                    protected void onSuccess(List<ProjectTypeBean> projectTypeBeans) {
                        mV.getProjectType(projectTypeBeans);
                    }

                    @Override
                    protected void onFailure(int errorCode, String errorMsg) {

                    }
                }));
//        addDisposable(RxRetrofit.getApi()
//                .getProjectType()
//                .compose(RxHelper.rxSchedulderHelper())
//                .compose(RxHelper.handleResult2())
//                .subscribeWith(new BaseObserver<List<ProjectTypeBean>>() {
//                    @Override
//                    protected void start() {
//
//                    }
//
//                    @Override
//                    protected void onSuccess(List<ProjectTypeBean> projectTypeBeans) {
//                        mV.getProjectType(projectTypeBeans);
//                    }
//
//                    @Override
//                    protected void onFailure(int errorCode, String errorMsg) {
//
//                    }
//                }));
    }
}
