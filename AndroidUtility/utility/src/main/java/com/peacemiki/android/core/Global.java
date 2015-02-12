package com.peacemiki.android.core;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Kevin on 2015. 2. 12..
 * Global instance offer the constant variables while application cycle.
 */
public enum Global {
    instance;

    private Context mApplicationContext;
    private DisplayMetrics mDisplayMetrics;

    public void setApplicationContext(Context context) {
        mApplicationContext = context;
    }

    public Context getApplicationContext() {
        return mApplicationContext;
    }

    public DisplayMetrics getDisplayMetrics() {
        if(mDisplayMetrics == null) {
            mDisplayMetrics = new DisplayMetrics();
            WindowManager wm = (WindowManager)mApplicationContext.getSystemService(Context.WINDOW_SERVICE);
            wm.getDefaultDisplay().getMetrics(mDisplayMetrics);
        }

        return mDisplayMetrics;
    }
}
