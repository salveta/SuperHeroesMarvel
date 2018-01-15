package superheroes.salvadorperez.com.superheroes.ui.detailSuperHeroe;

import android.content.Intent;

import superheroes.salvadorperez.com.superheroes.model.SuperHeroe;

/**
 * Created by Salva on 15/01/2018.
 */

interface ShDetailContract {

    interface view{
        void setSuperHeroeDetail(SuperHeroe superHeroe);
        void setErrorLoadDetail();
    }

    interface presenter{
        void getBundleData(Intent intentData);
    }
}
