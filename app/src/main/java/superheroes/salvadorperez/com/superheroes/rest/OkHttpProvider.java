package superheroes.salvadorperez.com.superheroes.rest;

import okhttp3.OkHttpClient;

/**
 * Created by Salva on 16/01/2018.
 */

public abstract class OkHttpProvider {
    private static OkHttpClient instance = null;

    public static OkHttpClient getOkHttpInstance() {
        if (instance == null) {
            instance = new OkHttpClient();
        }
        return instance;
    }
}
