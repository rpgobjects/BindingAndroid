package com.devfestmn.bindingandroid.model;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 1/11/16.
 */
public class SuperHero {
    String name;
    String alias;
    boolean avenger;
    String firstAppearance;
    String imageUrl;


    public String getAlias() {
        return alias;
    }

    public boolean isAvenger() {
        return avenger;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public static class Marvel {
        ArrayList<SuperHero> superHeros;
    }

    static public ArrayList<SuperHero> getSuperHeros(Context context) {
        String json  = AssetUtil.loadFromAsset("marvel.json",context);
        Marvel marvel = new Gson().fromJson(json,Marvel.class);
        return marvel.superHeros;
    }
}
