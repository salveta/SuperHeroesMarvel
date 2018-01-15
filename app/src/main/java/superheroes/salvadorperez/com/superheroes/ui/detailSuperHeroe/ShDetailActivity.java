package superheroes.salvadorperez.com.superheroes.ui.detailSuperHeroe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import superheroes.salvadorperez.com.superheroes.ApplicationConfig;
import superheroes.salvadorperez.com.superheroes.R;
import superheroes.salvadorperez.com.superheroes.commons.BaseActivity;
import superheroes.salvadorperez.com.superheroes.model.SuperHeroe;

/**
 * Created by Salva on 05/07/2017.
 */

public class ShDetailActivity extends BaseActivity implements ShDetailContract.view {

    @BindView(R.id.detail_superhero_image)      ImageView imImageDetail;
    @BindView(R.id.detail_superhero_real_name)  TextView tvRealName;
    @BindView(R.id.detail_superhero_height)     TextView tvHeight;
    @BindView(R.id.detail_superhero_power)      TextView tvPower;
    @BindView(R.id.detail_superhero_ability)    TextView tvAbilit;
    @BindView(R.id.detail_superhero_group)      TextView tvGroup;
    @BindView(R.id.toolbar)                     Toolbar mToolbar;

    private Unbinder unbinder;
    private ShDetailPresenter presenter;
    private Intent intendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail_superheroe);
        unbinder = ButterKnife.bind(this);

        presenter = new ShDetailPresenter(this);
        getDataFromIntent();
    }

    private void getDataFromIntent(){
        intendData = getIntent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getBundleData(getIntent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void setSuperHeroeDetail(SuperHeroe superHeroe) {
        setToolbar(superHeroe.getName());

        tvRealName.setText(superHeroe.getRealName());
        tvHeight.setText(superHeroe.getHeight());
        tvPower.setText(superHeroe.getPower());
        tvAbilit.setText(superHeroe.getAbilities());
        tvGroup.setText(superHeroe.getGroups());

        Picasso.with(ApplicationConfig.getContext()).load(superHeroe.getPhoto())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(imImageDetail);
    }

    @Override
    public void setErrorLoadDetail() {
        Toast.makeText(this, R.string.error_super_heroe_detail, Toast.LENGTH_SHORT).show();
    }

    private void setToolbar(String superHeroeName) {
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(superHeroeName);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
