package org.androidtown.vocabularybook;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by studio on 2015-11-22.
 */
public class Tab3Activity extends Activity{


    private WebView mWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab3_layout);
        setLayout();

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://endic.naver.com");
        mWebView.setWebViewClient(new WebViewClientClass());

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if((keyCode == KeyEvent.KEYCODE_BACK)&& mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }

    private void setLayout(){
        mWebView = (WebView)findViewById(R.id.webview);
    }


}
