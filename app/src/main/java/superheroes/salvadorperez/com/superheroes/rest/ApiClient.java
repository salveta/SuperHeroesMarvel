package superheroes.salvadorperez.com.superheroes.rest;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Salva on 15/01/2018.
 */

public class ApiClient {

    public static final String BASE_URL = "https://api.myjson.com/bins/bvyob/";
    private static Retrofit mRetrofit = null;
    private static ApiInterface mApiInterface;

    public static ApiInterface getMyApiClient() {
        getClient();
        return mApiInterface;
    }


    public static void getClient() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        mApiInterface = mRetrofit.create(ApiInterface.class);
    }
}
