package com.devfestmn.bindingandroid;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.devfestmn.bindingandroid.databinding.PojobindBinding;
import com.devfestmn.bindingandroid.handlers.Avengers;
import com.devfestmn.bindingandroid.model.SuperHero;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class PojoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PojobindBinding binding = DataBindingUtil.setContentView(this, R.layout.pojobind);
        ArrayList<SuperHero> heros = SuperHero.getSuperHeros(this);
        int i = new Random().nextInt(heros.size());
        binding.setSuperhero(heros.get(i));
        binding.setHandlers(new Avengers());
        binding.setIndex(i);
    }

    @BindingAdapter("binder:imageUrl")
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).placeholder(R.drawable.marvel_heroes).into(view);
    }

}
