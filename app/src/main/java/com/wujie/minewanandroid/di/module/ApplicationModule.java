package com.wujie.minewanandroid.di.module;

import android.app.Application;

import com.wujie.minewanandroid.MyApplication;
import com.wujie.minewanandroid.http.ApiServer;
import com.wujie.minewanandroid.http.ReadCookiesInterceptor;
import com.wujie.minewanandroid.http.SaveCookiesInterceptor;
import com.wujie.minewanandroid.util.Constant;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Time：2019/5/5 9:41
 * Author：WuChen
 * Description：
 **/
@Module
public class ApplicationModule {
    private MyApplication mMyApplication;
    private static HttpLoggingInterceptor mHttpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public ApplicationModule(MyApplication myApplication) {
        mMyApplication = myApplication;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return mMyApplication;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkhttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new SaveCookiesInterceptor())
                .addInterceptor(new ReadCookiesInterceptor())
                .addInterceptor(mHttpLoggingInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
//                .sslSocketFactory(getSSLSocketFactory(), new RxRetrofit.CustomTrustManager())
//                .hostnameVerifier(getHostnameVerifier())
                .build();
        return okHttpClient;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BaseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    public ApiServer provideServer(Retrofit retrofit) {
        return retrofit.create(ApiServer.class);
    }
}
