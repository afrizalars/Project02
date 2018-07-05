package com.example.zzulf.project02;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.location.Location;
import android.location.LocationManager;
import android.widget.TextView;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import at.markushi.ui.CircleButton;

public class InputDataKondisiDrainase extends AppCompatActivity {

    Button btnSaluranSamping, btnPenghubung, btnBahu, btnJalurPejalanKaki, btnKereb, btnLubang, btnHasil;
    ExpandableRelativeLayout expand1, expand2, expand3;
    RadioGroup rgTipe, rgLuas, rgAlur;
    CircleButton cbBack;

    TextView tvTIM, tvNamaJalan, tvLokasiJalan, tvLuasJalan;


    private static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    String lattitude, longitude;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_kondisi_drainase);

        tvLokasiJalan = findViewById(R.id.tvLokasiJalan);
        tvLuasJalan = findViewById(R.id.tvLuasJalan);
        tvNamaJalan = findViewById(R.id.tvNamaJalan);
        tvTIM = findViewById(R.id.tvTIM);

        btnSaluranSamping =findViewById(R.id.btnSaluranSamping);
        btnSaluranSamping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataKondisiDrainase.this, SaluranSamping1.class));
            }
        });

        btnPenghubung = findViewById(R.id.btnPenghubung);
        btnPenghubung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataKondisiDrainase.this, Penghubung.class));
            }
        });

        btnBahu = findViewById(R.id.btnBahu);
        btnBahu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataKondisiDrainase.this, Bahu.class));
            }
        });


        btnJalurPejalanKaki = findViewById(R.id.jalurPejalanKaki);
        btnJalurPejalanKaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataKondisiDrainase.this, JalurPejalanKaki.class));
            }
        });

        btnKereb = findViewById(R.id.btnKereb);
        btnKereb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataKondisiDrainase.this, Kereb.class));
            }
        });

        btnHasil = findViewById(R.id.btnHasil);
        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                    buildAlertMessageNoGps();
                }else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                    getLocation();
                }

                //Latitude longitude siap digunakan

                startActivity(new Intent(InputDataKondisiDrainase.this, HasilDrainase.class));
            }
        });

        cbBack = findViewById(R.id.cb_back);
        cbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataKondisiDrainase.this, JalanAtauDrainase.class));
            }
        });

    }

    private void buildAlertMessageNoGps() {


    }

    private void getLocation() {
        if(ActivityCompat.checkSelfPermission(InputDataKondisiDrainase.this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(InputDataKondisiDrainase.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ){

            ActivityCompat.requestPermissions(InputDataKondisiDrainase.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

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

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        startActivity(new Intent(InputDataKondisiDrainase.this,JalanAtauDrainase.class));
    }

}
