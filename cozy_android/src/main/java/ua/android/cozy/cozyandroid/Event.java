package ua.android.cozy.cozyandroid;

import android.util.Log;

/**
 * Created by Palamarenko Andrey on
 * 13.04.2018 22:13
 */

public class Event {

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
