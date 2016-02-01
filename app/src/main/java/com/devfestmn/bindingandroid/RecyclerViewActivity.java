package com.devfestmn.bindingandroid;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.devfestmn.bindingandroid.databinding.RecyclerviewBinding;
import com.squareup.picasso.Picasso;

public class RecyclerViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerviewBinding binding = DataBindingUtil.setContentView(this, R.layout.recyclerview);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new SuperHeroAdapter(this));
    }

    @BindingAdapter("binder:imageUrl")
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).placeholder(R.drawable.marvel_heroes).into(view);
    }

}
