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

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment {
    String nameStr, msgStr;
    EditText editTextName, editTextMsg;

    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_feedback, container, false);
        Button btnSubmit = (Button) v.findViewById(R.id.btnSubmit);
        editTextName = (EditText) v.findViewById(R.id.editTextName);
        editTextMsg = (EditText) v.findViewById(R.id.editTextMsg);

        btnSubmit.setOnClickListener(btnListener);

        return v;
    }


    private View.OnClickListener btnListener = new View.OnClickListener() {

        public void onClick(View v) {
            //do the same stuff or use switch/case and get each button ID and do different
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            nameStr = editTextName.getText().toString();
            msgStr = editTextMsg.getText().toString();

            Map<String, Object> feedback = new HashMap<>();
            feedback.put("name", nameStr);
            feedback.put("message", msgStr);

            db.collection("feedbacks")
                    .add(feedback)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast toast = Toast.makeText(getActivity().getBaseContext(), "Feedback Submitted.", Toast.LENGTH_LONG);
                            toast.show();
                            Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast toast = Toast.makeText(getActivity().getBaseContext(), "Feedback Failed to Submit..", Toast.LENGTH_LONG);
                            toast.show();
                            Log.w(TAG, "Error adding document", e);
                        }
                    });

        }

    };
}
