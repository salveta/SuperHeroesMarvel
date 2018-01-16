package superheroes.salvadorperez.com.superheroes.ui.superHeroeList;

import android.support.annotation.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

import superheroes.salvadorperez.com.superheroes.model.SuperHeroe;


/**
 * Created by Salva on 15/01/2018.
 */

public class ShPresenter implements ShContract.presenter, ShContract.model.OnGetSuperHeroes{

    private ShListActivity mView;
    private ShModel model;
    private List<SuperHeroe> mSuperHeroe = new ArrayList<>();

    public ShPresenter(ShListActivity view, ShModel model){
        this.mView = view;
        this.model = model;
    }

    @Override
    public void requestSuperHeroes() {
        mView.showLoading();
        model.getSuperHeroes(this);
    }

    @Override
    public void onSuccess(List<SuperHeroe> superHeroes) {
        mSuperHeroe = superHeroes;
        model.onDestroyObserver();
        mView.showSuperHeroesList(superHeroes);
        mView.hideLoading();
    }

    @Override
    public void onFailure(String error) {
        mView.hideLoading();
        mView.emptySuperHeroesList();
    }

    @Override
    public void openSuperHeroeDetail(int position) {
        SuperHeroe superHeroe = mSuperHeroe.get(position);
        mView.SuperHeroeDetail(superHeroe);
    }

    @VisibleForTesting
    public void openSuperHeroeDetail(int position, List<SuperHeroe> mSuperHeroe){
        SuperHeroe superHeroe = mSuperHeroe.get(position);
        mView.SuperHeroeDetail(superHeroe);
    }

}
