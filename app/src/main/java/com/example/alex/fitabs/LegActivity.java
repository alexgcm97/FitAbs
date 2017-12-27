package com.example.alex.fitabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class LegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg);

        ImageView imgLeg1 = (ImageView) findViewById(R.id.imgLeg1);
        ImageView imgLeg2 = (ImageView) findViewById(R.id.imgLeg2);
        ImageView imgLeg3 = (ImageView) findViewById(R.id.imgLeg3);

        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference imgRef1 = storageRef.child("leg1.jpg");
        StorageReference imgRef2 = storageRef.child("leg2.jpg");
        StorageReference imgRef3 = storageRef.child("leg3.jpg");

        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef1).into(imgLeg1);
        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef2).into(imgLeg2);
        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef3).into(imgLeg3);
    }
}
