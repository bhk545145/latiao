package com.example.app;

import android.content.Intent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.umeng.analytics.MobclickAgent;

public class MyAppWebViewClient extends WebViewClient {
    private Context mContext;
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().endsWith("taobao.com")) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            view.getContext().startActivity(intent);
            MobclickAgent.onEvent(mContext,"taobaoclick");
            return false;
        }else {
            view.loadUrl(url);
            MobclickAgent.onEvent(mContext,"urlclick");
            return true;
        }
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        MobclickAgent.onPageStart(url);
    }kend
}