package ua.android.cozy.cozyandroid.cozy;

import android.util.Log;

import ua.android.cozy.cozyandroid.BuildConfig;

/**
 * Created by Palamarenko Andrey on
 * 14.04.2018 11:24
 */

public class CozyEvent {

    public static void LOG_EVENT(String key, String mes) {
        String useKey = key != null ? key : "logos";
        String useMes = mes != null ? mes : "message == null";

        if (BuildConfig.DEBUG) Log.d(useKey, useMes);
    }

    public static void LOG_EVENT(String key, Object mes) {
        LOG_EVENT(key, String.valueOf(mes));
    }

    public static void LOG_EVENT(String key, Object... mes) {
        String message = "";
        for (int i = 0; i < mes.length; i++) {
            message += " (" + i + " - " + (mes[i] == null ? "null" : String.valueOf(mes[i]));
            message += ") ";
        }
        LOG_EVENT(key, String.valueOf(message));
    }
}
