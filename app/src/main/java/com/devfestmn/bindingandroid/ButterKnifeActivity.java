package com.devfestmn.bindingandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.devfestmn.bindingandroid.handlers.Avengers;
import com.devfestmn.bindingandroid.model.Marvel;
import com.devfestmn.bindingandroid.model.SuperHero;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButterKnifeActivity extends AppCompatActivity {

    @Bind(R.id.hero_image) ImageView heroImage;
    @Bind(R.id.hero_name) TextView heroName;
    @Bind(R.id.hero_alias) TextView heroAlias;
    @Bind(R.id.hero_first_appearance) TextView heroFirstAppearance;
    @Bind(R.id.hero_index) TextView heroIndex;
    @BindString(R.string.firstAppearanceLine) String firstAppearanceLine;

    SuperHero hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.butterknife);
        ButterKnife.bind(this);
        ArrayList<SuperHero> heros = Marvel.getSuperHeros(this);
        int i = new Random().nextInt(heros.size());
        hero = heros.get(i);
        Picasso.with(this).load(hero.getImageUrl()).placeholder(R.drawable.marvel_heroes).into(heroImage);
        heroName.setText(hero.getName());
        heroAlias.setText(hero.getAlias());
        if(hero.getAlias() == null) {
            heroAlias.setVisibility(View.GONE);
        }
        heroFirstAppearance.setText(String.format(firstAppearanceLine,hero.getName(),hero.getFirstAppearance()));
        heroIndex.setText(String.format("%d",i));
    }

    @OnClick(R.id.avenger_button)
    void onAvengerClick(View view) {
        if(hero.isAvenger()) {
            new Avengers().assemble(view);
        } else {
            new Avengers().notMember(view);
        }
    }
}
