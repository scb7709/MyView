package com.myview.utils;

import android.app.Activity;

import android.util.Log;

import org.xutils.HttpManager;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


/**
 * Created by abc on 2016/7/18.
 */
public class HttpUtils {
    private static HttpUtils httpUtils;
    static HttpManager httpManager;
    private static Activity context;


    public interface ResponseListener {
        void onResponse(String response);

        void onErrorResponse(Throwable ex);
    }



    public HttpUtils(Activity activity) {
        context = activity;
        httpManager = x.http();
        httpUtils = new HttpUtils();
    }

    public HttpUtils() {

    }

    public static HttpUtils getInstance(Activity activity) {
        context = activity;
        httpManager = x.http();
        if (httpUtils == null) {
            synchronized (HttpUtils.class) {
                if (httpUtils == null) {
                    httpUtils = new HttpUtils();
                }

            }
        }
        return httpUtils;
    }




    int  count=0;
    public void sendRequestRequestParams(final String dialogMessage, final RequestParams params, final boolean dialog, final ResponseListener responseListener) {

            httpManager.post(params, new Callback.CommonCallback<String>() {
                        @Override
                        public void onSuccess(String result) {

                                    responseListener.onResponse(result);



                        }

                        @Override
                        public void onError(Throwable ex, boolean isOnCallback) {
                            Log.i("AAAAACCCAAAA", ex.toString() + "'" + isOnCallback);

                                    responseListener.onErrorResponse(ex);


                        }

                        @Override
                        public void onCancelled(CancelledException cex) {

                        }

                        @Override
                        public void onFinished() {

                        }
                    }

            );

    }

}


