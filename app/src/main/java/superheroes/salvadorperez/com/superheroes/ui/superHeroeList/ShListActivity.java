package superheroes.salvadorperez.com.superheroes.ui.superHeroeList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import superheroes.salvadorperez.com.superheroes.ApplicationConfig;
import superheroes.salvadorperez.com.superheroes.R;
import superheroes.salvadorperez.com.superheroes.commons.BaseActivity;
import superheroes.salvadorperez.com.superheroes.model.SuperHeroe;
import superheroes.salvadorperez.com.superheroes.ui.detailSuperHeroe.ShDetailActivity;
import superheroes.salvadorperez.com.superheroes.ui.superHeroeList.adapter.ShAdapter;

/**
 * Created by Salva on 15/01/2018.
 */

public class ShListActivity extends BaseActivity implements ShContract.view{

    @BindView(R.id.rv_list_super_heroes)    RecyclerView rv_list_super_heroes;
    @BindView(R.id.progressBar)             ProgressBar progressBar;
    @BindView(R.id.rv_empty_text)           RelativeLayout rv_empty_text;

    private Unbinder unbinder;
    private ShAdapter adapter;
    private ShPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        setRecyclerView();
        initialiseList();

        presenter = new ShPresenter(this, new ShModel());
        presenter.requestSuperHeroes();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void initialiseList(){
        adapter.setListener((view, position) -> {
            presenter.openSuperHeroeDetail(position);
        });
    }

    private void setRecyclerView(){
        rv_list_super_heroes.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv_list_super_heroes.setLayoutManager(layoutManager);
        adapter = new ShAdapter();
        rv_list_super_heroes.setAdapter(adapter);
    }

    @Override
    public void showSuperHeroesList(List<SuperHeroe> superheroesData) {
        Collections.sort(superheroesData);
        adapter.addAll(superheroesData);
    }

    @Override
    public void emptySuperHeroesList() {
        rv_empty_text.setVisibility(View.VISIBLE);
    }

    @Override
    public void SuperHeroeDetail(SuperHeroe superHeroe) {
        Intent intent = new Intent(this, ShDetailActivity.class);
        intent.putExtra(ApplicationConfig.ARG_DETAIL, superHeroe);
        this.startActivity(intent);
    }


    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        if(progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
    }

}
