package ua.android.cozy.cozyandroid.rest;

/**
 * Created by Palamarenko Andrey on
 * 14.04.2018 10:44
 */

public class Rest {

    private ApiFactory apiFactory;
    private Class<? extends ApiGet> apiGet;

    public Rest(ApiFactory apiFactory) {
        this.apiFactory = apiFactory;
        this.apiGet = apiGet;
    }

    public ApiGet get() {
        return apiFactory.getApiService();
    }

    public ApiGet get(String baseUrl) {
        return apiFactory.getApiService(baseUrl);
    }



    public void restartRest(){
        apiFactory.resentClient();
    }




}

