package ua.android.cozy.cozyandroid.utils;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import io.reactivex.Single;

/**
 * Created by Palamarenko Andrey on
 * 14.04.2018 11:09
 */

public class TimeUtils extends Utils {

    private final String defaultPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private String pattern;


    public TimeUtils(Context context) {
        super(context);
        this.pattern = defaultPattern;
    }

    public TimeUtils(Context context, String pattern) {
        super(context);
        this.pattern = pattern;
    }

    public Single<Long> convertTimeToLocal(String time) {
        return convertTimeToLocal(time, pattern);
    }

    public Single<Long> convertTimeToLocal(String time, String pattern) {
        return Single.fromCallable(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat.parse(time).getTime();
        });
    }

    public Single<String> convertTimeFromLocal(Long time) {
        return convertTimeFromLocal(time, pattern);
    }

    public Single<String> convertTimeFromLocal(long time, String pattern) {

        return Single.fromCallable(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat.format(new Date(time));
        });
    }
}
