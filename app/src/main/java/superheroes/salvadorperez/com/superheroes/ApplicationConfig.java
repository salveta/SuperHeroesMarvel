package superheroes.salvadorperez.com.superheroes;

import android.app.Application;
import android.content.Context;

import superheroes.salvadorperez.com.superheroes.rest.ApiClient;
import superheroes.salvadorperez.com.superheroes.rest.ApiInterface;

/**
 * Created by Salva on 15/01/2018.
 */

public class ApplicationConfig extends Application {

    public final static String ARG_DETAIL = "arg_detail";
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationConfig.appContext = getApplicationContext();
    }

    public static ApplicationConfig getContext() {
        return (ApplicationConfig) appContext;
    }

    public static ApiInterface getApiService(){
        return ApiClient.getClient().create(ApiInterface.class);
    }
}
