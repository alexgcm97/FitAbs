package com.example.alex.fitabs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExerciseFragment extends Fragment {


    public ExerciseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_exercise, container, false);

        ImageButton btnLeg = (ImageButton) v.findViewById(R.id.btnLeg);
        btnLeg.setOnClickListener(btnListener);
        ImageButton btnArms = (ImageButton) v.findViewById(R.id.btnArms);
        btnArms.setOnClickListener(btnListener);
        ImageButton btnShoulders = (ImageButton) v.findViewById(R.id.btnShoulders);
        btnShoulders.setOnClickListener(btnListener);
        ImageButton btnBack = (ImageButton) v.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(btnListener);
        ImageButton btnChest = (ImageButton) v.findViewById(R.id.btnChest);
        btnChest.setOnClickListener(btnListener);
        return v;
    }

    private View.OnClickListener btnListener = new View.OnClickListener() {

        public void onClick(View v) {
            //do the same stuff or use switch/case and get each button ID and do different
            Intent intent = null;
            //stuff depending on the ID
            switch (v.getId()) {
                case R.id.btnChest:
                    intent = new Intent(getActivity(), ChestActivity.class);
                    break;
                case R.id.btnBack:
                    intent = new Intent(getActivity(), BackActivity.class);
                    break;
                 case R.id.btnLeg:
                    intent = new Intent(getActivity(), LegActivity.class);
                    break;
                case R.id.btnShoulders:
                    intent = new Intent(getActivity(), ShouldersActivity.class);
                    break;
                case R.id.btnArms:
                    intent = new Intent(getActivity(), ArmsActivity.class);
                    break;
            }
            startActivity(intent);

        }

    };
}
