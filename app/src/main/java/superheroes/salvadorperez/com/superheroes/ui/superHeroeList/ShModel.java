package superheroes.salvadorperez.com.superheroes.ui.superHeroeList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import superheroes.salvadorperez.com.superheroes.ApplicationConfig;
import superheroes.salvadorperez.com.superheroes.model.SuperHeroe;

/**
 * Created by Salva on 15/01/2018.
 */

public class ShModel implements ShContract.model {

    private Call<SuperHeroe> mCall;

    @Override
    public void getSuperHeroes(final OnGetSuperHeroes listener) {
        mCall = ApplicationConfig.getApiService().getSuperHeroes();
        mCall.enqueue(new Callback<SuperHeroe>() {
            @Override
            public void onResponse(Call<SuperHeroe> call, Response<SuperHeroe> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body().getSuperheroes());
                }
            }

            @Override
            public void onFailure(Call<SuperHeroe> call, Throwable t) {
                t.printStackTrace();
                listener.onFailure(t.toString());
            }
        });
    }
}
