package com.wujie.minewanandroid.data;

import com.wujie.minewanandroid.bean.BannerBean;
import com.wujie.minewanandroid.bean.BaseBean;
import com.wujie.minewanandroid.bean.HomeBean;
import com.wujie.minewanandroid.bean.KnowledgeBean;
import com.wujie.minewanandroid.bean.NavigationBean;
import com.wujie.minewanandroid.bean.PageListDataBean;
import com.wujie.minewanandroid.bean.ProjectItemBean;
import com.wujie.minewanandroid.bean.ProjectTypeBean;
import com.wujie.minewanandroid.bean.TodoBean;
import com.wujie.minewanandroid.http.ApiServer;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.http.Query;

/**
 * Time：2019/5/10 14:09
 * Author：WuChen
 * Description：
 **/
@Singleton
public class DataManager {

    private ApiServer mApiServer;

    @Inject
    public DataManager(ApiServer apiServer) {
        mApiServer = apiServer;
    }

    public Observable<BaseBean<PageListDataBean<HomeBean>>> getHomeList(int page) {
        return mApiServer.getHomeList(page);
    }

    public Observable<BaseBean<List<BannerBean>>> getBanner() {
        return mApiServer.getBanner();
    }

    public Observable<BaseBean<Object>> login(String username, String password) {
        return mApiServer.login(username, password);
    }

    public Observable<BaseBean<Object>> register(String username, String password, String repassword) {
        return mApiServer.register(username, password, repassword);
    }

    public Observable<BaseBean<Object>> collectArticle(int id) {
        return mApiServer.collectArticle(id);
    }

    public Observable<BaseBean<Object>> collectInsideArticle(int id) {
        return mApiServer.collectInsideArticle(id);
    }

    public Observable<BaseBean<Object>> unCollectArticle(int id) {
        return mApiServer.unCollectArticle(id);
    }

    public Observable<BaseBean<List<KnowledgeBean>>> getKnowledge() {
        return mApiServer.getKnowledge();
    }

    public Observable<BaseBean<List<NavigationBean>>> getNavigation() {
        return mApiServer.getNavigation();
    }

    public Observable<BaseBean<List<ProjectTypeBean>>> getProjectType() {
        return mApiServer.getProjectType();
    }

    public Observable<BaseBean<PageListDataBean<ProjectItemBean>>> getProjectList(@Query("cid") int cid) {
        return mApiServer.getProjectList(cid);
    }

    public Observable<BaseBean<TodoBean>> addTodo(String title, String content, String date, int type, int priority) {
        return mApiServer.addTodo(title, content, date, type, priority);
    }

    public Observable<BaseBean<PageListDataBean<TodoBean>>> getTodoList(int page, int status, int type, int priority, int orderby) {
        return mApiServer.getTodoList(page, status, type, priority, orderby);
    }
}
