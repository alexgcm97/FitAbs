package com.example.alex.fitabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class BackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        ImageView imgBack1 = (ImageView) findViewById(R.id.imgBack1);
        ImageView imgBack2 = (ImageView) findViewById(R.id.imgBack2);
        ImageView imgBack3 = (ImageView) findViewById(R.id.imgBack3);

        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference imgRef1 = storageRef.child("back1.jpg");
        StorageReference imgRef2 = storageRef.child("back2.jpg");
        StorageReference imgRef3 = storageRef.child("back3.jpg");

        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef1).into(imgBack1);
        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef2).into(imgBack2);
        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef3).into(imgBack3);
    }
}
