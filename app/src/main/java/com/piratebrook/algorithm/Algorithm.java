package com.piratebrook.algorithm;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @Author Pirate Brook
 * @Data 2018/6/29
 */
public class Algorithm extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
