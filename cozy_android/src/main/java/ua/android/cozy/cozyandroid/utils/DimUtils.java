package ua.android.cozy.cozyandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.preference.PreferenceManager;

/**
 * Created by Palamarenko Andrey on
 * 14.04.2018 11:08
 */

public class DimUtils extends Utils {

    private SharedPreferences preferences;
    private final String SCREEN_HEIGHT_KEY = "SCREEN_HEIGHT_KEY";
    private final String SCREEN_WIDTH_KEY = "SCREEN_WIDTH_KEY";


    public DimUtils(Context context) {
        super(context);
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }


    public void saveScreenSize(Activity activity) {
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(new Point());
        preferences.edit().putInt(SCREEN_HEIGHT_KEY, size.y).putInt(SCREEN_WIDTH_KEY, size.x).apply();
    }

    public int getScreenHeight() {
        int height = preferences.getInt(SCREEN_HEIGHT_KEY, -1);
        if (height == -1) {
            throw new IllegalStateException("Before call this method, you should call saveScreenSize()");
        }
        return height;
    }

    public int getScreenWidth() {
        int width = preferences.getInt(SCREEN_WIDTH_KEY, -1);
        if (width == -1) {
            throw new IllegalStateException("Before call this method, you should call saveScreenSize()");
        }
        return width;
    }


    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getContext().getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}

