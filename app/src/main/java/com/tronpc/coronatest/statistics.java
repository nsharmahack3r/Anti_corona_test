package com.tronpc.coronatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class statistics extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        String address = "https://raw.githubusercontent.com/nsharmahack3r/Anti-Corona/master/Statistics_today.png"; 
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl(address);
    }
}
