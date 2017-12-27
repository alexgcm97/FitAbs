package com.example.alex.fitabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ArmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arms);
        
        ImageView imgArms1 = (ImageView) findViewById(R.id.imgArms1);
        ImageView imgArms2 = (ImageView) findViewById(R.id.imgArms2);
        ImageView imgArms3 = (ImageView) findViewById(R.id.imgArms3);

        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference imgRef1 = storageRef.child("arms1.jpg");
        StorageReference imgRef2 = storageRef.child("arms2.jpg");
        StorageReference imgRef3 = storageRef.child("arms3.jpg");

        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef1).into(imgArms1);
        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef2).into(imgArms2);
        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef3).into(imgArms3);
    }
}
