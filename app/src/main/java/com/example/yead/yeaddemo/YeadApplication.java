package com.example.yead.yeaddemo;

import android.app.Application;

import com.example.yead.yeaddemo.util.UtilLog;

/**
 * Created by Yead on 2/6/2017.
 */

public class YeadApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);
    }
}
