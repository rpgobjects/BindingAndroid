package com.devfestmn.bindingandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.devfestmn.bindingandroid.databinding.ObservablecollectionBinding;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // NO Binding
        Button button = (Button) findViewById(R.id.pojo_binding_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PojoActivity.class));
            }
        });

        button = (Button) findViewById(R.id.baseobservable_binding_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BaseObservableActivity.class));
            }
        });

        button = (Button) findViewById(R.id.observablefield_binding_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ObservableFieldActivity.class));
            }
        });

        button = (Button) findViewById(R.id.observablecollection_binding_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ObservableCollectionActivity.class));
            }
        });

        button = (Button) findViewById(R.id.recyclerview_binding_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));
            }
        });

        button = (Button) findViewById(R.id.butterknife_binding_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ButterKnifeActivity.class));
            }
        });
    }

}
