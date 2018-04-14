package ua.android.cozy.cozyandroid.rest;

import android.support.annotation.NonNull;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.android.cozy.cozyandroid.BuildConfig;

/**
 * Created by Palamarenko Andrey on
 * 14.04.2018 10:00
 */


public class ApiFactory<T extends ApiGet> {
    private final int CONNECT_TIMEOUT = 45;
    private final int WRITE_TIMEOUT = 45;
    private final int TIMEOUT = 45;

    private OkHttpClient client;

    private final String BASE_URL;
    private final Class<T> aClass;


    public ApiFactory(String BASE_URL,Class<T> aClass) {
       this.BASE_URL = BASE_URL;
       this.aClass = aClass;
    }

    private OkHttpClient getClient() {

        if (client == null) {

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            addInterceptors(builder);

            builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
            builder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
            builder.readTimeout(TIMEOUT, TimeUnit.SECONDS);
            client = builder.build();

        }
        return client;
    }


    public void resentClient(){
        client = null;
    }


    public void addInterceptors(OkHttpClient.Builder builder) {
        builder.addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder()
                    .header("Accept", "application/json")
                    .header("Cache-Control", "no-cache")
                    .method(original.method(), original.body());
            Request request = requestBuilder
                    .cacheControl(new CacheControl.Builder().noCache().build())
                    .build();

            return chain.proceed(request);
        });
    }


    @NonNull
    public T getApiService() {
        return getRest().create(aClass);
    }

    @NonNull
    public T getApiService(String baseUrl) {
        return getRest(baseUrl).create(aClass);
    }

    @NonNull
    public Retrofit getRest() {
        return getRest(BASE_URL);
    }

    @NonNull
    public Retrofit getRest(String baseUrl) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .client(getClient())
                .build();
    }


}

