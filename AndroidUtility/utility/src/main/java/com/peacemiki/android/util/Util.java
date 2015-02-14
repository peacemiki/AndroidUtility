package com.peacemiki.android.util;

import android.util.DisplayMetrics;

import com.peacemiki.android.core.Global;

/**
 * Created by Kevin on 2015. 2. 12..
 */
public class Util {
    public static int dp2px(float dp) {
        int px = 0;
        DisplayMetrics m = Global.instance.getDisplayMetrics();

        assert m != null;

        px = (int)(dp * m.density);

        return px;
    }

    public static float px2dp(int px) {
        float dp = 0.f;
        DisplayMetrics m = Global.instance.getDisplayMetrics();

        assert m != null;

        dp = px / m.density;

        return dp;
    }
}
