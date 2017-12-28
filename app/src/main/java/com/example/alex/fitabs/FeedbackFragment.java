package com.example.alex.fitabs;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment {
    String nameStr, msgStr, emailStr;
    EditText editTextName, editTextMsg, editTextEmail;
    Button btnSubmit, btnReset;
    int count = 0;
    Date date = new Date();
    DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_feedback, container, false);
        btnSubmit = (Button) v.findViewById(R.id.btnSubmit);
        btnReset = (Button) v.findViewById(R.id.btnReset);
        editTextName = (EditText) v.findViewById(R.id.editTextName);
        editTextMsg = (EditText) v.findViewById(R.id.editTextMsg);
        editTextEmail = (EditText) v.findViewById(R.id.editTextEmail);

        btnSubmit.setOnClickListener(btnListener);
        btnReset.setOnClickListener(btnListener);

        return v;
    }


    private View.OnClickListener btnListener = new View.OnClickListener() {

        public void onClick(View v) {
            //do the same stuff or use switch/case and get each button ID and do different
            switch (v.getId()) {
                case R.id.btnSubmit: {
                    if (count > 3) {
                        btnSubmit.setClickable(false);
                        Toast toast = Toast.makeText(getActivity().getBaseContext(), "Sorry, you have reached the daily feedback count of 3 submits.", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    nameStr = editTextName.getText().toString();
                    emailStr = editTextEmail.getText().toString();
                    msgStr = editTextMsg.getText().toString();
                    if (msgStr.isEmpty() || nameStr.isEmpty() || emailStr.isEmpty()) {
                        Toast toast = Toast.makeText(getActivity().getBaseContext(), "Please check your name, email or message.", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Map<String, Object> feedback = new HashMap<>();
                        feedback.put("name", nameStr);
                        feedback.put("email", emailStr);
                        feedback.put("dateTime", df.format(date));
                        feedback.put("message", msgStr);

                        db.collection("feedbacks")
                                .add(feedback)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Toast toast = Toast.makeText(getActivity().getBaseContext(), "Feedback Submitted.\nDaily Feedback Count:" + ++count + " out of 3", Toast.LENGTH_SHORT);
                                        toast.show();
                                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast toast = Toast.makeText(getActivity().getBaseContext(), "Feedback Failed to Submit..", Toast.LENGTH_SHORT);
                                        toast.show();
                                        Log.w(TAG, "Error adding document", e);
                                    }
                                });
                    }
                    break;
                }
                case R.id.btnReset:{
                    editTextName.setText("");
                    editTextName.setFocusable(true);
                    editTextEmail.setText("");
                    editTextMsg.setText("");
                    break;
                }
            }
        }

    };
}
