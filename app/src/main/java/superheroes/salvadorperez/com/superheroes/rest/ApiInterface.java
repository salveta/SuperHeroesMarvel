package superheroes.salvadorperez.com.superheroes.rest;


import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import superheroes.salvadorperez.com.superheroes.model.SuperHeroe;

/**
 * Created by Salva on 15/01/2018.
 */

public interface ApiInterface {
    @GET(".")
    Single<Response<SuperHeroe>> getSuperHeroes();
}
