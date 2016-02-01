package com.devfestmn.bindingandroid;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devfestmn.bindingandroid.databinding.SuperheroItemBinding;
import com.devfestmn.bindingandroid.model.Marvel;
import com.devfestmn.bindingandroid.model.SuperHero;

import java.util.ArrayList;

/**
 * Created by chris on 2/1/16.
 */
public class SuperHeroAdapter extends RecyclerView.Adapter<SuperHeroAdapter.SuperHeroHolder> {

    ArrayList<SuperHero> heros;

    public SuperHeroAdapter(Context context) {
        heros = Marvel.getSuperHeros(context);
    }

    @Override
    public SuperHeroHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.superhero_item, parent, false);
        return new SuperHeroHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SuperHeroHolder holder, int position) {
        holder.superheroItemBinding.setSuperhero(heros.get(position));
    }

    @Override
    public int getItemCount() {
        return heros.size();
    }

    public static class SuperHeroHolder extends RecyclerView.ViewHolder {
        SuperheroItemBinding superheroItemBinding;

        public SuperHeroHolder(View itemView) {
            super(itemView);
            superheroItemBinding = DataBindingUtil.bind(itemView);
        }
    }
}
