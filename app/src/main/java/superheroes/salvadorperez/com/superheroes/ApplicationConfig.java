package superheroes.salvadorperez.com.superheroes;

import android.app.Application;
import android.content.Context;

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
}
