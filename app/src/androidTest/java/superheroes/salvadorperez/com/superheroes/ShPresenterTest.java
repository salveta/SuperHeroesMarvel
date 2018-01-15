package superheroes.salvadorperez.com.superheroes;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import superheroes.salvadorperez.com.superheroes.model.SuperHeroe;
import superheroes.salvadorperez.com.superheroes.ui.superHeroeList.ShListActivity;
import superheroes.salvadorperez.com.superheroes.ui.superHeroeList.ShModel;
import superheroes.salvadorperez.com.superheroes.ui.superHeroeList.ShPresenter;

import static org.mockito.Mockito.verify;

/**
 * Created by Salva on 15/01/2018.
 */

public class ShPresenterTest {
    @Mock
    private ShPresenter presenter;

    @Mock
    private ShListActivity view;

    private SuperHeroe superHeroe;

    @Rule
    public final ActivityTestRule mActivityRule = new ActivityTestRule<>(ShListActivity.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new ShPresenter(view, new ShModel());
    }

    @Test
    public void checkLoaingEnableWhenGetSuperheroes(){
        presenter.requestSuperHeroes();
        verify(view).showLoading();
    }

    @Test
    public void showErrors(){
        presenter.onFailure("");
        verify(view).hideLoading();
        verify(view).emptySuperHeroesList();
    }

    @Test
    public void openDetailPosition(){
        presenter.openSuperHeroeDetail(0, fakeUser());
        verify(view).SuperHeroeDetail(superHeroe);
    }

    public List<SuperHeroe> fakeUser(){
        List<SuperHeroe> mSuperHeroe = new ArrayList<>();

        superHeroe = new SuperHeroe();
        superHeroe.setName("name");
        superHeroe.setAbilities("abilities");
        superHeroe.setGroups("groups");
        superHeroe.setHeight("height");
        superHeroe.setPower("power");
        superHeroe.setRealName("realName");
        superHeroe.setPhoto("photo");

        SuperHeroe superHeroe2 = new SuperHeroe();
        superHeroe2.setName("name");
        superHeroe2.setAbilities("abilities");
        superHeroe2.setGroups("groups");
        superHeroe2.setHeight("height");
        superHeroe2.setPower("power");
        superHeroe2.setRealName("realName");
        superHeroe2.setPhoto("photo");

        mSuperHeroe.add(superHeroe);
        mSuperHeroe.add(superHeroe2);

        return mSuperHeroe;
    }

}
