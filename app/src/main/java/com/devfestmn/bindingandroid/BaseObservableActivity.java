package com.devfestmn.bindingandroid;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.devfestmn.bindingandroid.databinding.BaseobserveBindBinding;
import com.devfestmn.bindingandroid.databinding.PojobindBinding;
import com.devfestmn.bindingandroid.handlers.Avengers;
import com.devfestmn.bindingandroid.model.Marvel;
import com.devfestmn.bindingandroid.model.SuperHero;
import com.devfestmn.bindingandroid.model.SuperHeroObservable;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class BaseObservableActivity extends AppCompatActivity {

    SuperHeroObservable superHeroObservable = new SuperHeroObservable();
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseobserveBindBinding binding = DataBindingUtil.setContentView(this, R.layout.baseobserve_bind);
        setRandomSuperhero(null);
        binding.setSuperhero(superHeroObservable);
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
        superHeroObservable.setName(superHero.getName());
        superHeroObservable.setAlias(superHero.getAlias());
        superHeroObservable.setAvenger(superHero.isAvenger());
        superHeroObservable.setFirstAppearance(superHero.getFirstAppearance());
        superHeroObservable.setImageUrl(superHero.getImageUrl());
    }

}
