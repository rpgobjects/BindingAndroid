package com.devfestmn.bindingandroid;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.devfestmn.bindingandroid.databinding.ObservablecollectionBinding;
import com.devfestmn.bindingandroid.databinding.ObservablefieldBinding;
import com.devfestmn.bindingandroid.handlers.Avengers;
import com.devfestmn.bindingandroid.model.Marvel;
import com.devfestmn.bindingandroid.model.SuperHero;
import com.devfestmn.bindingandroid.model.SuperHeroPlain;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class ObservableCollectionActivity extends AppCompatActivity {

    ObservableArrayMap<String, Object> superHeroMap = new ObservableArrayMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ObservablecollectionBinding binding = DataBindingUtil.setContentView(this, R.layout.observablecollection);
        setRandomSuperhero(null);
        binding.setSuperhero(superHeroMap);
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
        superHeroMap.put("name", superHero.getName());
        superHeroMap.put("alias", superHero.getAlias());
        superHeroMap.put("avenger", superHero.isAvenger());
        superHeroMap.put("firstAppearance", superHero.getFirstAppearance());
        superHeroMap.put("imageUrl", superHero.getImageUrl());
    }

}
