package com.example.eventmanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HostActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
        this.getSupportActionBar().setTitle("Current Host");
         database = FirebaseDatabase.getInstance();
         myRef = database.getReference();

        // Read from the database
        myRef=database.getReference().child("host").child("name");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                TextView name=findViewById(R.id.name1);
                String value = dataSnapshot.getValue(String.class);
                name.setText("Name- " +value);
               // Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
               // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        myRef=database.getReference().child("host").child("email");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                TextView name=findViewById(R.id.ema);
                String value = dataSnapshot.getValue(String.class);
                name.setText("Email- "+value);
                // Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        myRef=database.getReference().child("host").child("phone");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                TextView name=findViewById(R.id.pha);
                String value = dataSnapshot.getValue(String.class);
                name.setText("Phone- "+value);
                // Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
    public void chg(View view){
        Intent intent=new Intent(getApplicationContext(),Checkhost.class);
        startActivity(intent);

    }
    public void dir(View view){
        Intent intent=new Intent(getApplicationContext(),ChangeHost.class);
        startActivity(intent);

    }
}
