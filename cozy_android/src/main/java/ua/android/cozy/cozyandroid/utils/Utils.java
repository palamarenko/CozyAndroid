package ua.android.cozy.cozyandroid.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Palamarenko Andrey on
 * 14.04.2018 11:06
 */

public class Utils {

    private Context context;


    public Utils(Context context) {
        this.context = context;
    }

    protected Context getContext() {
        return context;
    }

    public String getStringByName(String key) {
        String packageName = context.getPackageName();
        int resId = context.getResources().getIdentifier(key, "string", packageName);
        try {
            return getString(resId);
        } catch (Exception e) {
            return "Don't find";
        }
    }

    public String getString(@StringRes int id) {
        return context.getResources().getString(id);
    }

    public List<String> getStringList(@ArrayRes int id) {
        return new ArrayList<>(Arrays.asList(context.getResources().getStringArray(id)));
    }

    public Drawable getDrawable(@DrawableRes int id) {
        return ContextCompat.getDrawable(context, id);
    }

    public int getColor(@ColorRes int id) {
        return ContextCompat.getColor(context, id);
    }


    public int dpToPx(float dp) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) px;
    }

    public float pxToDp(int pixel) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = pixel / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    public int dpToPx(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) px;
    }


}

