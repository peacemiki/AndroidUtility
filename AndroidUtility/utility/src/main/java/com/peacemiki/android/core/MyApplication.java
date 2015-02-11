package com.peacemiki.android.core;

import android.app.Application;

import com.peacemiki.android.util.TaskUtil;

/**
 * Created by kevin on 15. 2. 11..
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(TaskUtil.instance);
    }
}
