package com.example.jago.css639firebase;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment  implements View.OnClickListener {
    FirebaseDatabase database;
    Firebase mRootRef;
    DatabaseReference myRef;
    EditText etId, etFirstName;
    Button btnSubmit;
    String id, firstName;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_main, container, false);

        Student student = new Student("POO", "LOIU");

        database = FirebaseDatabase.getInstance();
         myRef = database.getReference("red");
        //myRef.setValue("Hello, !");





        btnSubmit = (Button) v.findViewById(R.id.submitBtn);

        etId = (EditText) v.findViewById(R.id.editLastName);
        etFirstName = (EditText) v.findViewById(R.id.editFirstName);
        etFirstName.setText( myRef.toString());

        btnSubmit.setOnClickListener(this);



        return v;


    }

    @Override
    public void onStart() {
        super.onStart();

//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                etId.setText(value);
//                Log.v( "Value is: " ,value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//            }
//        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        btnSubmit = (Button) getView().findViewById(R.id.submitBtn);


    }

    @Override
    public void onClick(View view) {

        id= etId.getText().toString().trim();
        firstName = etFirstName.getText().toString().trim();
        Student student = new Student(id, firstName);
        myRef.push().setValue(student);

    }
}
