package superheroes.salvadorperez.com.superheroes.ui.superHeroeList.adapter;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import superheroes.salvadorperez.com.superheroes.ApplicationConfig;
import superheroes.salvadorperez.com.superheroes.R;
import superheroes.salvadorperez.com.superheroes.commons.BaseListViewHolder;
import superheroes.salvadorperez.com.superheroes.commons.ItemClickListener;
import superheroes.salvadorperez.com.superheroes.model.SuperHeroe;

/**
 * Created by Salva on 15/01/2018.
 */

public class ShViewHolder extends BaseListViewHolder<SuperHeroe> {

    @BindView(R.id.thumbnail)           ImageView imSuperHeroe;
    @BindView(R.id.superheroe_name)     TextView tvNameSuperHeroe;
    @BindView(R.id.card_view)           CardView cardView;

    @Override
    public void render(SuperHeroe item) {
        Picasso.with(ApplicationConfig.getContext()).load(item.getPhoto())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(imSuperHeroe);

        tvNameSuperHeroe.setText(item.getName());
    }

    @Override
    public void onClick(View view) {
        if (itemClickListener != null) {
            itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public ShViewHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView, itemClickListener);
        ButterKnife.bind(this, itemView);
    }
}