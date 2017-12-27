package com.example.alex.fitabs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeFragment extends Fragment {


    public RecipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recipe, container, false);
        ImageButton btnRecipe1 = (ImageButton) v.findViewById(R.id.btnRecipe1);
        btnRecipe1.setOnClickListener(btnListener);
        ImageButton btnRecipe2 = (ImageButton) v.findViewById(R.id.btnRecipe2);
        btnRecipe2.setOnClickListener(btnListener);
        ImageButton btnRecipe3 = (ImageButton) v.findViewById(R.id.btnRecipe3);
        btnRecipe3.setOnClickListener(btnListener);
        ImageButton btnRecipe4 = (ImageButton) v.findViewById(R.id.btnRecipe4);
        btnRecipe4.setOnClickListener(btnListener);

        StorageReference storageRef = FirebaseStorage.getInstance().getReference().child("recipe");
        StorageReference imgRef1 = storageRef.child("recipe1.jpeg");
        StorageReference imgRef2 = storageRef.child("recipe2.jpeg");
        StorageReference imgRef3 = storageRef.child("recipe3.jpeg");
        StorageReference imgRef4 = storageRef.child("recipe4.jpeg");

        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef1).into(btnRecipe1);
        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef2).into(btnRecipe2);
        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef3).into(btnRecipe3);
        Glide.with(this).using(new FirebaseImageLoader()).load(imgRef4).into(btnRecipe4);

        return v;
    }

    private View.OnClickListener btnListener = new View.OnClickListener() {

        public void onClick(View v) {
            //do the same stuff or use switch/case and get each button ID and do different
            Intent intent = null;
            //stuff depending on the ID
            switch (v.getId()) {
                case R.id.btnRecipe1:
                    intent = new Intent(getActivity(), Recipe1Activity.class);
                    break;
                case R.id.btnRecipe2:
                    intent = new Intent(getActivity(), Recipe2Activity.class);
                    break;
                case R.id.btnRecipe3:
                    intent = new Intent(getActivity(), Recipe3Activity.class);
                    break;
                case R.id.btnRecipe4:
                    intent = new Intent(getActivity(), Recipe4Activity.class);
                    break;
            }
            startActivity(intent);

        }

    };

}
