package com.example.alex.fitabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        ImageView imgChest1 = (ImageView) findViewById(R.id.imgChest1);
        ImageView imgChest2 = (ImageView) findViewById(R.id.imgChest2);
        ImageView imgChest3 = (ImageView) findViewById(R.id.imgChest3);

        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference imgRef1 = storageRef.child("chest1.jpg");
        StorageReference imgRef2 = storageRef.child("chest2.jpg");
        StorageReference imgRef3 = storageRef.child("chest3.png");

        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef1).into(imgChest1);
        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef2).into(imgChest2);
        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef3).into(imgChest3);
    }
}
