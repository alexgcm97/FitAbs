package com.example.alex.fitabs;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imgLeg1 = findViewById(R.id.imgLeg1);
        ImageView imgLeg2 = findViewById(R.id.imgLeg2);
        ImageView imgLeg3 = findViewById(R.id.imgLeg3);

        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference imgRef1 = storageRef.child("leg1.jpg");
        StorageReference imgRef2 = storageRef.child("leg2.jpg");
        StorageReference imgRef3 = storageRef.child("leg3.jpg");

        Glide.with(this).load(imgRef1).into(imgLeg1);
        Glide.with(this).load(imgRef2).into(imgLeg2);
        Glide.with(this).load(imgRef3).into(imgLeg3);

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
