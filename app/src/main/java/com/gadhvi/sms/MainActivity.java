package com.gadhvi.sms;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b1,b2;
    private int STORAGE_PERMISSION_CODE = 23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.sendsms);
       b2= (Button)findViewById(R.id.maps);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED) {
                    SmsManager sms = SmsManager.getDefault();
                    String phoneNumber = "9892379125";
                    String message = "Sms successfully tested";
                    sms.sendTextMessage(phoneNumber, null, message, null, null);
                } else {
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
// Show rationale and request permission.
                }


                }



        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(i1);
            }
        });






    }
}
