package com.example.alex.fitabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BMIFragment extends Fragment {
    private EditText editTextHeight, editTextWeight;
    private TextView textViewResult;
    private Button btnCalculate, btnReset;

    public BMIFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bmi, container, false);

        editTextHeight = (EditText) v.findViewById(R.id.editTextHeight);
        editTextWeight = (EditText) v.findViewById(R.id.editTextWeight);
        textViewResult = (TextView) v.findViewById(R.id.textViewResult);
        btnCalculate = (Button) v.findViewById(R.id.btnCalculate);
        btnReset = (Button) v.findViewById(R.id.btnReset);
        btnCalculate.setOnClickListener(btnListener);
        btnReset.setOnClickListener(btnListener);
        return v;
    }

    private View.OnClickListener btnListener = new View.OnClickListener() {

        public void onClick(View v) {
            //do the same stuff or use switch/case and get each button ID and do different
            //stuff depending on the ID
            switch (v.getId()) {
                case R.id.btnCalculate: {
                    Double weight = 0.0, height = 0.0;
                    Double bmi = 0.0;
                    String status = "";

                    weight = Double.valueOf(editTextWeight.getText().toString());
                    height = Double.valueOf(editTextHeight.getText().toString()) / 100;

                    bmi = weight / (height * height);

                    if (bmi < 18.5) {
                        status = getResources().getString(R.string.under_weight);
                    } else if (bmi >= 18.5 && bmi <= 24.9) {
                        status = getResources().getString(R.string.normal);
                    } else {
                        status = getResources().getString(R.string.over_weight);
                    }
                    textViewResult.setText(getResources().getString(R.string.bmi) + String.format("%1.2f", bmi) + "\n" +  getResources().getString(R.string.status) + status);
                    break;
                }
                case R.id.btnReset: {
                    editTextWeight.setText("");
                    editTextWeight.setFocusable(true);
                    editTextHeight.setText("");
                    textViewResult.setText("");
                    break;
                }
            }
        }

    };
}
