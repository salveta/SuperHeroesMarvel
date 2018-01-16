package superheroes.salvadorperez.com.superheroes.ui.superHeroeList;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import superheroes.salvadorperez.com.superheroes.rest.ApiClient;

/**
 * Created by Salva on 15/01/2018.
 */

public class ShModel implements ShContract.model {

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void getSuperHeroes(final OnGetSuperHeroes listener) {
        mCompositeDisposable.add(ApiClient.getMyApiClient().getSuperHeroes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(superHeroeResponse ->
                                listener.onSuccess(superHeroeResponse.body().getSuperheroes()),
                       throwable ->
                               listener.onFailure(throwable.toString())));

    }

    @Override
    public void onDestroyObserver() {
        mCompositeDisposable.clear();
    }
}
