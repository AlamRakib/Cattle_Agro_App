package com.rakibitfarm.sylhetcattle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class CowFeedActivity extends AppCompatActivity {


    WebView  webView;

    public static  String pdf_link = "https://khamar-e.com/food-routine-for-cow/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_feed);

        webView = findViewById(R.id.webViewId);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();


        if (networkInfo != null && networkInfo.isConnected()) {

            webView.setWebViewClient(new WebViewClient());
            Toast.makeText(CowFeedActivity.this,"Wait a few second! page is loading...",Toast.LENGTH_SHORT).show();
            webView.loadUrl(pdf_link);
        }
        else{

            new AlertDialog.Builder(CowFeedActivity.this)
                    .setTitle("No internet")
                    .setMessage("please connect internet")
                    .show();

        }



    }


    public void onBackPressed(){
        if (webView.canGoBack()) {
            webView.goBack();
        }else{

            Intent intent = new Intent(CowFeedActivity.this,MainActivity.class);
            startActivity(intent);

            finish();
        }
    }
}