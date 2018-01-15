package superheroes.salvadorperez.com.superheroes.ui.superHeroeList.adapter;

import android.view.ViewGroup;

import java.util.List;

import superheroes.salvadorperez.com.superheroes.R;
import superheroes.salvadorperez.com.superheroes.commons.BaseAdapterList;
import superheroes.salvadorperez.com.superheroes.commons.BaseListViewHolder;
import superheroes.salvadorperez.com.superheroes.model.SuperHeroe;

/**
 * Created by Salva on 15/01/2018.
 */

public class ShAdapter extends BaseAdapterList<SuperHeroe> {

    @Override
    public BaseListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ShViewHolder(inflate(viewGroup, i), itemClickListener);
    }

    @Override
    public void onBindViewHolder(BaseListViewHolder holder, final int position) {
        holder.render(data.get(position));
    }

    @Override
    public SuperHeroe getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_superheroe;
    }

    @Override
    public List<SuperHeroe> getItems() {
        return data;
    }

    @Override
    public void set(List<SuperHeroe> superHeroes) {
        validateCollection(superHeroes);
        notifyDataSetChanged();
    }
}
