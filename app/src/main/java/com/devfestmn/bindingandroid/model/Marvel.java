package com.devfestmn.bindingandroid.model;

import android.content.Context;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Marvel {

    ArrayList<SuperHero> superHeros;

    static public ArrayList<SuperHero> getSuperHeros(Context context) {
        String json  = AssetUtil.loadFromAsset("marvel.json",context);
        Marvel marvel = new Gson().fromJson(json,Marvel.class);
        return marvel.superHeros;
    }
}
