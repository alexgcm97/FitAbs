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

public class Recipe1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe1);
        StorageReference storageRef = FirebaseStorage.getInstance().getReference().child("recipe/recipe1.jpeg");
        ImageView imgRecipe1 = (ImageView) findViewById(R.id.imgRecipe1);
        Glide.with(this).using(new FirebaseImageLoader()).load(storageRef).into(imgRecipe1);
        TextView textRecipe1 = (TextView) findViewById(R.id.textRecipe1);
        textRecipe1.setMovementMethod(new ScrollingMovementMethod());
    }
}
