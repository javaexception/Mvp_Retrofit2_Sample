package com.qzs.mvp_retrofit2_sample.mvp.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;




public class MyApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
   //     LeakCanary.install(this);
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
