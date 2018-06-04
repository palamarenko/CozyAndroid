package ua.android.cozy.cozyandroid.rest;


public class Rest<T extends ApiGet> {

    private ApiFactory<T> apiFactory;

    public Rest(ApiFactory<T> apiFactory) {
        this.apiFactory = apiFactory;
    }

    public T get() {
        return apiFactory.getApiService();
    }

    public T get(String baseUrl) {
        return apiFactory.getApiService(baseUrl);
    }


    public void restartRest(){
        apiFactory.resentClient();
    }




}

