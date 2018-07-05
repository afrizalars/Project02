package com.example.zzulf.project02;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import at.markushi.ui.CircleButton;

public class URCI extends AppCompatActivity {
    EditText etICS, etIRD, etCorrugation, etDust, etPotholes, etRuts, etLoose;
    CircleButton btnBack, btnFinish;

    String lattitude, longitude;
    private static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urci);

        btnBack = findViewById(R.id.cb_back);
        btnFinish = findViewById(R.id.cb_finish);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(URCI.this, InputJalanURCI.class));
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                    buildAlertMessageNoGps();
                }else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                    getLocation();
                }

                Log.d("latlong",lattitude+longitude);

                startActivity(new Intent(URCI.this, HasilURCI.class));

            }
        });
    }

    private void buildAlertMessageNoGps() {


    }

    private void getLocation() {
        if(ActivityCompat.checkSelfPermission(URCI.this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(URCI.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ){

            ActivityCompat.requestPermissions(URCI.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        }else{

            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (location != null){
                double latti = location.getLatitude();
                double longi = location.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);

                //Lat long sudah siap

            }else{
                double latti = location.getLatitude();
                double longi = location.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);
                Toast.makeText(this, "Tidak bisa melacak lokasi", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
