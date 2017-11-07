package com.myview.activity;

import android.app.Application;

import org.xutils.x;

/**
 * Created by abc on 2017/11/6.
 */
public class APP  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //Xutils3 初始化
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
