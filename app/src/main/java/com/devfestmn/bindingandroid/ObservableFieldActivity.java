package com.devfestmn.bindingandroid;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.devfestmn.bindingandroid.databinding.ObservablefieldBinding;
import com.devfestmn.bindingandroid.handlers.Avengers;
import com.devfestmn.bindingandroid.model.Marvel;
import com.devfestmn.bindingandroid.model.SuperHero;
import com.devfestmn.bindingandroid.model.SuperHeroPlain;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class ObservableFieldActivity extends AppCompatActivity {

    SuperHeroPlain superHeroPlain = new SuperHeroPlain();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ObservablefieldBinding binding = DataBindingUtil.setContentView(this, R.layout.observablefield);
        setRandomSuperhero(null);
        binding.setSuperhero(superHeroPlain);
        binding.setHandlers(new Avengers());
    }

    @BindingAdapter("binder:imageUrl")
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).placeholder(R.drawable.marvel_heroes).into(view);
    }

    public void setRandomSuperhero(View button) {
        ArrayList<SuperHero> heros = Marvel.getSuperHeros(this);
        int i = new Random().nextInt(heros.size());
        SuperHero superHero = heros.get(i);
        superHeroPlain.name.set(superHero.getName());
        superHeroPlain.alias.set(superHero.getAlias());
        superHeroPlain.avenger.set(superHero.isAvenger());
        superHeroPlain.firstAppearance.set(superHero.getFirstAppearance());
        superHeroPlain.imageUrl.set(superHero.getImageUrl());
    }

}
