package com.myview.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.myview.R;
import com.myview.utils.HttpUtils;
import com.myview.view.TestView;

import org.xutils.http.RequestParams;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestView button=(TestView)findViewById(R.id.TestView);
        webView=(WebView)findViewById(R.id.WebView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("response1", " dddddddd");
                testMyInterface(MainActivity.this);
            }
        });//
      //支持javascript
        webView.getSettings().setJavaScriptEnabled(true);
// 设置可以支持缩放
        webView.getSettings().setSupportZoom(true);
// 设置出现缩放工具
        webView.getSettings().setBuiltInZoomControls(true);
//扩大比例的缩放
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webView.getSettings().setLoadWithOverviewMode(true);
      //  webView.setWebViewClient(new webViewClient());
        String url="http://192.168.1.151:7777/AndroidTest/reporttest.jsp";
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }


    //消息推送获取DeviceToken接口   http://localhost:    http://192.168.1.151
    public static void testMyInterface(final Activity activity) {
            RequestParams params = new RequestParams("http://192.168.1.151:7777/AndroidTest/AndroidTestServlet");
            params.addBodyParameter("flag","params");

            HttpUtils.getInstance(activity).sendRequestRequestParams("", params, false, new HttpUtils.ResponseListener() {
                        @Override
                        public void onResponse(String response) {
                            Log.i("response1", response.toString());

                        }

                        @Override
                        public void onErrorResponse(Throwable ex) {
                            Log.i("response2", ex.toString());


                        }


                    }

            );

        }

}
