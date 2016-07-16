package com.recipe.newcle.sidedish;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetailActivity extends AppCompatActivity {
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail);
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);      // 웹뷰에서 자바 스크립트 사용
        Intent intent = getIntent();
        String uri = intent.getStringExtra("uri");
        mWebView.loadUrl(uri);            // 웹뷰에서 불러올 URL 입력

        mWebView.setWebViewClient(new WishWebViewClient());
    }

   private class WishWebViewClient extends WebViewClient {
        public String mCurrentUrl;

        @Override

        public boolean shouldOverrideUrlLoading(WebView view, String url){
            if(mCurrentUrl != null && url !=null && url.equals(mCurrentUrl)){
                mWebView.goBack();
            }else {
                view.loadUrl(url);
                mCurrentUrl = url;
            }
            return true;

        }

    }
}
