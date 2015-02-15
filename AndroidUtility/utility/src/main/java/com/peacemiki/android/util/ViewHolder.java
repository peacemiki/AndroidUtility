package com.peacemiki.android.util;

import android.util.SparseArray;
import android.view.View;

/**
 * http://www.kmshack.kr/android-유연성-있는-viewholder-pattern
 */
public class ViewHolder {
    public static <T extends View> T get(View v, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>)v.getTag();

        if(viewHolder == null) {
            viewHolder = new SparseArray<View>();
            v.setTag(viewHolder);
        }

        View childView = viewHolder.get(id);
        if(childView == null) {
            childView = v.findViewById(id);
            viewHolder.put(id, childView);
        }

        return (T) childView;
    }
}
