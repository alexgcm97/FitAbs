package com.example.alex.fitabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ChestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imgChest1 = findViewById(R.id.imgChest1);
        ImageView imgChest2 = findViewById(R.id.imgChest2);
        ImageView imgChest3 = findViewById(R.id.imgChest3);

        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference imgRef1 = storageRef.child("chest1.jpg");
        StorageReference imgRef2 = storageRef.child("chest2.jpg");
        StorageReference imgRef3 = storageRef.child("chest3.png");

        Glide.with(this).load(imgRef1).into(imgChest1);
        Glide.with(this).load(imgRef2).into(imgChest2);
        Glide.with(this).load(imgRef3).into(imgChest3);
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
