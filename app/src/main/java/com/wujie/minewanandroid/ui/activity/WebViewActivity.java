package com.wujie.minewanandroid.ui.activity;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.wujie.minewanandroid.BaseActivity;
import com.wujie.minewanandroid.R;
import com.wujie.minewanandroid.util.ARouterUtils;
import com.wujie.minewanandroid.util.Constant;
import butterknife.BindView;

/**
 * Time：2019/1/11 0011 上午 11:24
 * Author：WuChen
 * Description：
 **/
@Route(path = ARouterUtils.WebViewPath)
public class WebViewActivity extends BaseActivity {

    WebView mWebView;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.fl_container)
    FrameLayout mFlContainer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void init() {
        String webUrl = getIntent().getStringExtra(Constant.WebUrl);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mWebView = new WebView(getApplicationContext());
        mWebView.setLayoutParams(lp);
        mFlContainer.addView(mWebView, 0);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.loadUrl(webUrl);
        mProgressBar.setMax(100);

        mWebView.setWebChromeClient(new WebChromeClient() {

            //获取网页的标题
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
//                Toast.makeText(mContext, "" + title, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                mProgressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        if (mWebView != null) {
            mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebView.clearHistory();
            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }

}
