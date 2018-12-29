package com.justmobiledev.androidpoppingstack1;

import android.app.Application;
import android.content.res.Configuration;

public class MyApplication extends Application {

    private static MyApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }


    public static MyApplication getApplication(){
        return application;
    }
}