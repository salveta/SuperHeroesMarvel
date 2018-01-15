package superheroes.salvadorperez.com.superheroes.ui.detailSuperHeroe;

import android.content.Intent;

import superheroes.salvadorperez.com.superheroes.ApplicationConfig;
import superheroes.salvadorperez.com.superheroes.model.SuperHeroe;

/**
 * Created by Salva on 15/01/2018.
 */

public class ShDetailPresenter implements ShDetailContract.presenter {

    ShDetailActivity mView;

    public ShDetailPresenter(ShDetailActivity view){
        this.mView = view;
    }

    @Override
    public void getBundleData(Intent intentData) {
        if(intentData != null) {
            mView.setSuperHeroeDetail((SuperHeroe) intentData.getSerializableExtra(ApplicationConfig.ARG_DETAIL));
        }else{
            mView.setErrorLoadDetail();
        }
    }
}
