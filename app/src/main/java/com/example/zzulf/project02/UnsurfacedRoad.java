package com.example.zzulf.project02;

import android.*;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import at.markushi.ui.CircleButton;

public class UnsurfacedRoad extends AppCompatActivity {
    private static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    String lattitude, longitude;
    CircleButton btnInput;
    String namaJalan, namaTim;
    float lebar;
    public double lat_awal,lng_awal;
    EditText etNamaJalan, etTimSurvey, etLebar;

    void Inisialisasi(){
        etLebar = findViewById(R.id.et_lebar);
        etNamaJalan = findViewById(R.id.et_namajalan);
        etTimSurvey = findViewById(R.id.et_timsurvey);
    }

    void PushData(){
        namaJalan = etNamaJalan.getText().toString();
        namaTim = etTimSurvey.getText().toString();
        lebar = Float.valueOf(etLebar.getText().toString());
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unsurfaced_road);

        Inisialisasi();

        editTextContent();


        SharedPreferences dataUser = this.getSharedPreferences("dataUser",MODE_PRIVATE);
        final SharedPreferences.Editor editor = dataUser.edit();

        btnInput = findViewById(R.id.btn_input);
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etNamaJalan.getText().toString().isEmpty() && !etLebar.getText().toString().isEmpty() &&
                        !etTimSurvey.getText().toString().isEmpty()){
                    PushData();
                    editor.putString("namaJalan",namaJalan);
                    editor.putString("timSurvey",namaTim);
                    editor.putFloat("lebar",lebar);
                    editor.commit();
                    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                    if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                        buildAlertMessageNoGps();
                    }else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                        getLocation();
                    }

                    //Latitude longitude siap digunakan
                    Log.d("latlong1  : ",lattitude+", "+longitude);
                    startActivity(new Intent(UnsurfacedRoad.this, InputDataJalan.class));
                } else{
                    Toast.makeText(UnsurfacedRoad.this, "Data belum terisi.",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void buildAlertMessageNoGps() {


    }

    private void getLocation() {
        if(ActivityCompat.checkSelfPermission(UnsurfacedRoad.this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(UnsurfacedRoad.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ){

            ActivityCompat.requestPermissions(UnsurfacedRoad.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

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

    void editTextContent(){
        SharedPreferences dataUser = this.getSharedPreferences("dataUser",MODE_PRIVATE);
        lebar = Float.valueOf(etLebar.getText().toString());

        if(dataUser.getString("namaJalan",null) != null){
            etNamaJalan.setText(dataUser.getString("namaJalan",null));
        }

        if(dataUser.getString("timSurvey",null) != null){
            etTimSurvey.setText(dataUser.getString("timSurvey",null));
        }

        // if(dataUser.getString("lebar", null) != null){
        //     etLebar.setText(dataUser.getString("lebar",null));
        //}

    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        startActivity(new Intent(UnsurfacedRoad.this,MainMenu.class));
    }

}
