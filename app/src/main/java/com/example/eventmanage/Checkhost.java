package com.example.eventmanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Checkhost extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkhost);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        myRef=database.getReference().child("host").child("email");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                TextView email=findViewById(R.id.email);
                String value = dataSnapshot.getValue(String.class);
                email.setText(value);
                // Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }
    public void val(View view){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        myRef=database.getReference().child("host").child("pass");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                EditText pass=findViewById(R.id.pass);
                String value = dataSnapshot.getValue(String.class);
                if(!value.equals(pass.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please Enter Correct Password",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent=new Intent(getApplicationContext(),ChangeHost.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }
}
