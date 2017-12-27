package com.example.alex.fitabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ShouldersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulders);

        ImageView imgShoulders1 = (ImageView) findViewById(R.id.imgShoulders1);
        ImageView imgShoulders2 = (ImageView) findViewById(R.id.imgShoulders2);
        ImageView imgShoulders3 = (ImageView) findViewById(R.id.imgShoulders3);

        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference imgRef1 = storageRef.child("shoulder1.jpg");
        StorageReference imgRef2 = storageRef.child("shoulder2.jpg");
        StorageReference imgRef3 = storageRef.child("shoulder3.jpg");

        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef1).into(imgShoulders1);
        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef2).into(imgShoulders2);
        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef3).into(imgShoulders3);
    }
}
