package io.github.datwheat.juwan.ui.utils;

import android.content.Context;

public class DimensionUtils {
    public static int pxToDp(Context context, int px) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (px * density);
    }
}
