package com.example.eventmanage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Checkin extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    String memail,mphone,mna;
    private static final int PERMISSION_SEND_SMS = 123;
    int f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);
        this.getSupportActionBar().setTitle("Check In");
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        EditText name=findViewById(R.id.nm);
        EditText email=findViewById(R.id.em);
        EditText cin = findViewById(R.id.cin);
        EditText phone=findViewById(R.id.ph);


        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        String curr = dateFormat.format(Calendar.getInstance().getTime());
       // String curr=currentTime.toString();


        cin.setText(curr);
        requestSmsPermission();
        myRef=database.getReference().child("host").child("email");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //TextView email=findViewById(R.id.email);
                String value = dataSnapshot.getValue(String.class);
                memail=value;

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
                //TextView email=findViewById(R.id.email);
                String value = dataSnapshot.getValue(String.class);
                mphone=value;

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        myRef=database.getReference().child("host").child("name");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //TextView email=findViewById(R.id.email);
                String value = dataSnapshot.getValue(String.class);
                mna=value;

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

//        myRef.child("Visitor").child(phone.getText().toString()).child("name").setValue(name.getText().toString());
//        myRef.child("Visitor").child(phone.getText().toString()).child("email").setValue(email.getText().toString());
//        myRef.child("Visitor").child(phone.getText().toString()).child("timestamp").setValue(curr);
//        myRef.child("Visitor").child(phone.getText().toString()).child("Checked").setValue("in");

    }

    private void requestSmsPermission() {

        // check permission is given
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            // request permission (see result in onRequestPermissionsResult() method)
            ActivityCompat.requestPermissions(Checkin.this,
                    new String[]{Manifest.permission.SEND_SMS},
                    PERMISSION_SEND_SMS);
        } else {

        }
    }
    public void ch(View view) {
        Date currentTime = Calendar.getInstance().getTime();
        String curr = currentTime.toString();


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        EditText name = findViewById(R.id.nm);
        EditText email = findViewById(R.id.em);
        EditText phone = findViewById(R.id.ph);
        EditText cin = findViewById(R.id.cin);
        EditText add=findViewById(R.id.add1);
       // cin.setText(curr);
       // EditText cout = findViewById(R.id.cout);


        if (phone.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter all the details",
                    Toast.LENGTH_LONG).show();
        } else {
            myRef = database.getReference();
            myRef.child("Visitor").child(phone.getText().toString()).child("name").setValue(name.getText().toString());
            myRef.child("Visitor").child(phone.getText().toString()).child("email").setValue(email.getText().toString());
            myRef.child("Visitor").child(phone.getText().toString()).child("timestampIn").setValue(curr);
            myRef.child("Visitor").child(phone.getText().toString()).child("Checked").setValue(1);
            myRef.child("Visitor").child(phone.getText().toString()).child("Phone").setValue(phone.getText().toString());
            myRef.child("Visitor").child(phone.getText().toString()).child("CheckIn").setValue(cin.getText().toString());
            myRef.child("Visitor").child(phone.getText().toString()).child("Address").setValue(add.getText().toString());

            //   myRef.child("Visitor").child(phone.getText().toString()).child("CheckOut").setValue(cout.getText().toString());
            myRef.child("Visitor").child(phone.getText().toString()).child("host").setValue(mna);



//        myRef=database.getReference().child("Visitor").child(phone.getText().toString()).child("Checked");
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                TextView email=findViewById(R.id.email);
//                Integer value = dataSnapshot.getValue(Integer.class);
//                if(value==1){
//                    Toast.makeText(getApplicationContext(),"You are already Checked in !!",Toast.LENGTH_SHORT).show();
//                    f=1;
//                }else{             database = FirebaseDatabase.getInstance();
//                    myRef = database.getReference();
//                    EditText name=findViewById(R.id.nm);
//                    EditText phone=findViewById(R.id.ph);
//                    Date currentTime = Calendar.getInstance().getTime();
//                    String curr=currentTime.toString();     myRef.child("Visitor").child(phone.getText().toString()).child("timestampIn").setValue(curr);
//                    Toast.makeText(getApplicationContext(),"You are Checked in !!",Toast.LENGTH_SHORT).show();                }
//                // Log.d(TAG, "Value is: " + value);
//            }

//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                // Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });


            //send email,text to host


            String n=name.getText().toString();
            String p=phone.getText().toString();
            String e=email.getText().toString();
            String ci=cin.getText().toString();
         //   String co=cout.getText().toString();
            String message="Visitor Details : \n"+"Name - "+n+"\nEmail - "+e+"\nPhone - "+p+"\nCheckIn Time - "+ci;

            JavaMailAPI javaMailAPI = new JavaMailAPI(this, memail, "Visitor - "+ n +" Details", message);

            javaMailAPI.execute();
            //send

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

            //Get the SmsManager instance and call the sendTextMessage method to send message
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(mphone, null, message, pi, null);

            Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                    Toast.LENGTH_LONG).show();

        }
    }
}
