package com.example.eventmanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChangeHost extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_host);
        this.getSupportActionBar().setTitle("Change Host");
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
    }
    public void change(View view){

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        EditText name=findViewById(R.id.name1);
        EditText email=findViewById(R.id.email1);
        EditText pass=findViewById(R.id.pass1);
        EditText pho=findViewById(R.id.pho);
        String s=name.getText().toString();
        myRef=database.getReference();
        myRef.child("host").child("name").setValue(s);
        myRef.child("host").child("email").setValue(email.getText().toString());
        myRef.child("host").child("pass").setValue(pass.getText().toString());
        myRef.child("host").child("phone").setValue(pho.getText().toString());
        Toast.makeText(getApplicationContext(),"Host Details Updated Sucessfully",Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }
}
