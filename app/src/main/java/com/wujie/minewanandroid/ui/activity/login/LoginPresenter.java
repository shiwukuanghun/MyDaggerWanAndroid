package com.wujie.minewanandroid.ui.activity.login;

import com.wujie.minewanandroid.data.DataManager;
import com.wujie.minewanandroid.http.BaseObserver;
import com.wujie.minewanandroid.http.RxRetrofit;
import com.wujie.minewanandroid.presenter.BasePresenter;
import com.wujie.minewanandroid.ui.activity.login.LoginContact;
import com.wujie.minewanandroid.util.RxHelper;

import javax.inject.Inject;

public class LoginPresenter extends BasePresenter<LoginContact.View> implements LoginContact.Presenter {

    private DataManager mDataManager;

    @Inject
    public LoginPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void login(String username, String password) {
        addDisposable(mDataManager
        .login(username, password)
                .compose(RxHelper.rxSchedulderHelper())
                .compose(RxHelper.handleResult2())
                .subscribeWith(new BaseObserver<Object>() {
                    @Override
                    protected void start() {

                    }

                    @Override
                    protected void onSuccess(Object o) {
                        mV.loginSuccess();
                    }

                    @Override
                    protected void onFailure(int errorCode, String errorMsg) {
                        mV.showFailure(errorMsg);
                    }
                }));
//        addDisposable(RxRetrofit.getApi()
//                .login(username, password)
//                .compose(RxHelper.rxSchedulderHelper())
//                .compose(RxHelper.handleResult2())
//                .subscribeWith(new BaseObserver<Object>() {
//                    @Override
//                    protected void start() {
//
//                    }
//
//                    @Override
//                    protected void onSuccess(Object o) {
//                        mV.loginSuccess();
//                    }
//
//                    @Override
//                    protected void onFailure(int errorCode, String errorMsg) {
//                        mV.showFailure(errorMsg);
//                    }
//                }));
    }
/*    @Override
    public void login(String username, String password) {
        addDisposable(RxRetrofit.createApi(ApiServer.class, Constant.BaseUrl)
                .login(username, password)
                .compose(RxHelper.rxSchedulderHelper())
                .compose(RxHelper.handleResult2())
                .subscribeWith(new BaseObserver<Object>() {
                    @Override
                    protected void start() {

                    }

                    @Override
                    protected void onSuccess(Object o) {
                        mV.loginSuccess();
                    }

                    @Override
                    protected void onFailure(int errorCode, String errorMsg) {
                        mV.showFailure(errorMsg);
                    }
                }));


    }*/

    /*@Override
    public void login(String username, String password) {
        RxObserver<Object> rxObserver = new RxObserver<Object>(this) {
            @Override
            protected void start() {

            }

            @Override
            protected void onSuccess(Object o) {
                mV.loginSuccess();
            }

            @Override
            protected void onFailure(int errorCode, String errorMsg) {
                mV.showFailure(errorMsg);
            }
        };
        RxRetrofit.createApi(ApiServer.class, Constant.BaseUrl)
                .login(username, password)
                .compose(RxHelper.rxSchedulderHelper())
                .subscribe(rxObserver);
        addDisposable(rxObserver);
    }*/
}
