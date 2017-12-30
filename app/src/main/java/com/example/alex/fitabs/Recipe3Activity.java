package com.example.alex.fitabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        StorageReference storageRef = FirebaseStorage.getInstance().getReference().child("recipe/recipe3.jpeg");
        ImageView imgRecipe3 = findViewById(R.id.imgRecipe3);
        Glide.with(this).load(storageRef).into(imgRecipe3);
        TextView textRecipe3 = findViewById(R.id.textRecipe3);
        textRecipe3.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // this takes the user 'back', as if they pressed the left-facing triangle icon on the main android toolbar.
                // if this doesn't work as desired, another possibility is to call `finish()` here.
                this.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
