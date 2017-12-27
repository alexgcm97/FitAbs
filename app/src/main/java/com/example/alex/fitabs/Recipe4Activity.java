package com.example.alex.fitabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Recipe4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe4);
        StorageReference storageRef = FirebaseStorage.getInstance().getReference().child("recipe/recipe4.jpeg");
        ImageView imgRecipe4 = (ImageView) findViewById(R.id.imgRecipe4);
        Glide.with(this).using(new FirebaseImageLoader()).load(storageRef).into(imgRecipe4);

        TextView textRecipe4 = (TextView) findViewById(R.id.textRecipe4);
        textRecipe4.setMovementMethod(new ScrollingMovementMethod());
    }
}
