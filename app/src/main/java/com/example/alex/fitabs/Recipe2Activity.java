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

public class Recipe2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe2);
        StorageReference storageRef = FirebaseStorage.getInstance().getReference().child("recipe/recipe2.jpeg");
        ImageView imgRecipe2 = findViewById(R.id.imgRecipe2);
        Glide.with(this).load(storageRef).into(imgRecipe2);
        TextView textRecipe2 = findViewById(R.id.textRecipe2);
        textRecipe2.setMovementMethod(new ScrollingMovementMethod());
    }
}
