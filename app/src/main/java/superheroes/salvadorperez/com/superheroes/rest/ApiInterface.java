package superheroes.salvadorperez.com.superheroes.rest;


import retrofit2.Call;
import retrofit2.http.GET;
import superheroes.salvadorperez.com.superheroes.model.SuperHeroe;

/**
 * Created by Salva on 15/01/2018.
 */

public interface ApiInterface {
    @GET(".")
    Call<SuperHeroe> getSuperHeroes();
}
