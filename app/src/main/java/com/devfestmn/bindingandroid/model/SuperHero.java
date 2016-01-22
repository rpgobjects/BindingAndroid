package com.devfestmn.bindingandroid.model;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


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
}
