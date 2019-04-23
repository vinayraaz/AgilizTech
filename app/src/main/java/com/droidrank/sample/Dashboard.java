package com.droidrank.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Dashboard extends AppCompatActivity {
    private WebView webView = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);
        this.webView = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        webView.setWebViewClient(webViewClient);

        new Thread(new Runnable() {
            @Override

            public void run() {
                try {

                    Thread.sleep(1000);

                } catch (Exception e) {

                }

            }
        }).start();
        webView.loadUrl("http://www.agiliztech.com/about-us/");
    }
}
