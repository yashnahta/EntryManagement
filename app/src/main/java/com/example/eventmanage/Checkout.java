package com.example.eventmanage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Checkout extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    int f = 0;
    String h,ci,co,n;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        EditText name = findViewById(R.id.nm);
        EditText email = findViewById(R.id.em);
        EditText phone = findViewById(R.id.ph);
        Date currentTime = Calendar.getInstance().getTime();
        String curr = currentTime.toString();
//        myRef.child("Visitor").child(phone.getText().toString()).child("name").setValue(name.getText().toString());
//        myRef.child("Visitor").child(phone.getText().toString()).child("email").setValue(email.getText().toString());
//        myRef.child("Visitor").child(phone.getText().toString()).child("timestamp").setValue(curr);
//        myRef.child("Visitor").child(phone.getText().toString()).child("Checked").setValue("in");
        myRef=database.getReference().child("host").child("name");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //TextView email=findViewById(R.id.email);
                String value = dataSnapshot.getValue(String.class);
                h=value;
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

//
        email.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                EditText phone = findViewById(R.id.ph);
              //  Toast.makeText(getApplicationContext(),phone.getText().toString(),Toast.LENGTH_SHORT).show();

                myRef=database.getReference().child("Visitor").child(phone.getText().toString()).child("CheckIn");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        //TextView email=findViewById(R.id.email);
                        String value = dataSnapshot.getValue(String.class);
                        ci=value;
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        // Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

                myRef=database.getReference().child("Visitor").child(phone.getText().toString()).child("CheckOut");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        //TextView email=findViewById(R.id.email);
                        String value = dataSnapshot.getValue(String.class);
                        co=value;
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        // Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

                myRef=database.getReference().child("Visitor").child(phone.getText().toString()).child("name");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        //TextView email=findViewById(R.id.email);
                        String value = dataSnapshot.getValue(String.class);
                        n=value;
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        // Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

                return false;
            }
        });






    }

    public void ch(View view) {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        EditText name = findViewById(R.id.nm);
        EditText email = findViewById(R.id.em);
        EditText phone = findViewById(R.id.ph);
        Date currentTime = Calendar.getInstance().getTime();
        String curr = currentTime.toString();
        if (phone.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter all the details",
                    Toast.LENGTH_LONG).show();
        } else {
            myRef = database.getReference();
//            myRef.child("Visitor").child(phone.getText().toString()).child("name").setValue(name.getText().toString());
           myRef.child("Visitor").child(phone.getText().toString()).child("email").setValue(email.getText().toString());
            myRef.child("Visitor").child(phone.getText().toString()).child("timestampOut").setValue(curr);
            myRef.child("Visitor").child(phone.getText().toString()).child("Checked").setValue(0);
//            myRef.child("Visitor").child(phone.getText().toString()).child("Phone").setValue(phone.getText().toString());


//        myRef=database.getReference().child("Visitor").child(phone.getText().toString()).child("Checked");
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                TextView email=findViewById(R.id.email);
//                Integer value = dataSnapshot.getValue(Integer.class);
//                if(value==0){
//                    Toast.makeText(getApplicationContext(),"You are already Checked out !!",Toast.LENGTH_SHORT).show();
//                    f=1;
//                }
//                else{
//                    database = FirebaseDatabase.getInstance();
//                    myRef = database.getReference();
//                    EditText name=findViewById(R.id.nm);
//                    EditText phone=findViewById(R.id.ph);
//                    Date currentTime = Calendar.getInstance().getTime();
//                    String curr=currentTime.toString();
//                    myRef.child("Visitor").child(phone.getText().toString()).child("timestampOut").setValue(curr);
//                    Toast.makeText(getApplicationContext(),"You are Checked out !!",Toast.LENGTH_SHORT).show();
//                }
//                // Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                // Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });


            //send email,text to host


            //send




            String p=phone.getText().toString();
            String message="Visitor Details : \n"+"Name - "+n+"\nPhone - "+p+"\nCheckIn Time - "+ci+"\nCheckOut Time - "+co+"\nHost - "+h;


            JavaMailAPI javaMailAPI = new JavaMailAPI(this, email.getText().toString(), "Meeting Details with Host - "+h, message);

            javaMailAPI.execute();

//        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
//        PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
//
//        //Get the SmsManager instance and call the sendTextMessage method to send message
//        SmsManager sms= SmsManager.getDefault();
//        sms.sendTextMessage("9416212317", null,"hello", pi,null);
//
//        Toast.makeText(getApplicationContext(), "Message Sent successfully!",
//                Toast.LENGTH_LONG).show();

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }

}