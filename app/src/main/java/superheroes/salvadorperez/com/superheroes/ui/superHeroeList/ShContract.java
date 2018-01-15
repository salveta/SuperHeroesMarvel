package superheroes.salvadorperez.com.superheroes.ui.superHeroeList;

import java.util.List;

import superheroes.salvadorperez.com.superheroes.model.SuperHeroe;

/**
 * Created by Salva on 15/01/2018.
 */

interface ShContract {

    interface view{
        void showSuperHeroesList(List<SuperHeroe> superheroesData);
        void emptySuperHeroesList();
        void showLoading();
        void hideLoading();
        void SuperHeroeDetail(SuperHeroe superHeroe);
    }

    interface presenter{
        void requestSuperHeroes();
        void openSuperHeroeDetail(int position);
    }

    interface model{
        interface OnGetSuperHeroes {
            void onSuccess(List<SuperHeroe> superHeroes);
            void onFailure(String error);
        }

        void getSuperHeroes(OnGetSuperHeroes listener);
    }
}
