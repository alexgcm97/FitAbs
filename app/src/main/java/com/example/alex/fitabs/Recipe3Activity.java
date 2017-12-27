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

public class Recipe3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe3);

        StorageReference storageRef = FirebaseStorage.getInstance().getReference().child("recipe/recipe3.jpeg");
        ImageView imgRecipe3 = (ImageView) findViewById(R.id.imgRecipe3);
        Glide.with(this).using(new FirebaseImageLoader()).load(storageRef).into(imgRecipe3);
        TextView textRecipe3 = (TextView) findViewById(R.id.textRecipe3);
        textRecipe3.setMovementMethod(new ScrollingMovementMethod());
    }
}
