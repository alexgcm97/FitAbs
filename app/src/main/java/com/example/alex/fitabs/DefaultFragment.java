package com.example.alex.fitabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class DefaultFragment extends Fragment {
    public DefaultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        StorageReference storageRef = FirebaseStorage.getInstance().getReference().child("quote");
        System.out.println(storageRef);
        StorageReference imgRef = null;

        Date date = new Date();
        View v = inflater.inflate(R.layout.fragment_default, container, false);
        ImageView imgQuote = (ImageView) v.findViewById(R.id.imgQuote);
        switch (date.getDay()) {
            case 1:
                imgRef = storageRef.child("monday.jpg");
                break;
            case 2:
                imgRef = storageRef.child("tuesday.jpg");
                break;
            case 3:
                imgRef = storageRef.child("wednesday.jpg");
                break;
            case 4:
                imgRef = storageRef.child("thursday.jpeg");
                break;
            case 5:
                imgRef = storageRef.child("friday.jpg");
                break;
            case 6:
                imgRef = storageRef.child("saturday.jpg");
                break;
            case 7:
                imgRef = storageRef.child("sunday.jpg");
                break;
        }
        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef).into(imgQuote);
        return v;
    }

}
