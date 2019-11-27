package com.example.eventmanage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_SEND_SMS = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Home");
        this.getSupportActionBar().setTitle("HomeScreen");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        requestSmsPermission();

       // myRef.child("host").child("name").setValue("yash");
    }

    private void requestSmsPermission() {

        // check permission is given
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            // request permission (see result in onRequestPermissionsResult() method)
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.SEND_SMS},
                    PERMISSION_SEND_SMS);
        } else {
        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
//
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // permission was granted
//                   // sendSms(phone, message);
//                } else {
//                    // permission denied
//                }
//                return;
//            }
//        }
//    }

    public void chin(View view) {
        Intent intent=new Intent(getApplicationContext(),Checkin.class);
        startActivity(intent);
    }

    public void chout(View view) {
        Intent intent=new Intent(getApplicationContext(),Checkout.class);
        startActivity(intent);
    }

    public void host(View view) {
        Intent intent=new Intent(getApplicationContext(),HostActivity.class);
        startActivity(intent);

    }
}
