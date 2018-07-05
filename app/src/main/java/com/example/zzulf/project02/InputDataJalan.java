package com.example.zzulf.project02;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.location.Location;
import android.location.LocationManager;
import android.widget.TextView;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.Map;

import at.markushi.ui.CircleButton;

public class InputDataJalan extends AppCompatActivity {

    private static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;

    Button btnSaluranSamping, btnPenghubung, btnBahu, btnJalurPejalanKaki, btnKereb, btnHasilD;
    Button btnRetakan, btnAlur, btnTambalan, btnKekerasanPermukaan, btnAmblas, btnLubang, btnHasil;
    ExpandableRelativeLayout expand1, expand2, expand3;
    CircleButton cbBack;
    String lattitude, longitude;
    TextView tvTIM, tvNamaJalan, tvLokasiJalan, tvLuasJalan;

    void Inisialisasi(){
        tvLokasiJalan = findViewById(R.id.tvLokasiJalan);
        tvLuasJalan = findViewById(R.id.tvLuasJalan);
        tvNamaJalan = findViewById(R.id.tvNamaJalan);
        tvTIM = findViewById(R.id.tvTIM);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_jalan);

        Inisialisasi();

        SharedPreferences dataUser = this.getSharedPreferences("dataUser",MODE_PRIVATE);
        SharedPreferences retakan1 = this.getSharedPreferences("retakan1",MODE_PRIVATE);
        SharedPreferences retakan2 = this.getSharedPreferences("retakan2",MODE_PRIVATE);
        SharedPreferences retakan3 = this.getSharedPreferences("retakan3",MODE_PRIVATE);
        SharedPreferences kedalaman = this.getSharedPreferences("kedalaman",MODE_PRIVATE);
        SharedPreferences Tambalan = this.getSharedPreferences("tambalan",MODE_PRIVATE);
        SharedPreferences Lubang = this.getSharedPreferences("Lubang",MODE_PRIVATE);
        SharedPreferences Kekerasan = this.getSharedPreferences("Kekerasan",MODE_PRIVATE);
        SharedPreferences Amblas = this.getSharedPreferences("Amblas",MODE_PRIVATE);


        Map<String,String> datauser = (Map<String, String>) dataUser.getAll();
        Map<String,String> retak1 = (Map<String, String>) retakan1.getAll();
        Map<String,String> retak2 = (Map<String, String>) retakan2.getAll();
        Map<String,String> retak3 = (Map<String, String>) retakan3.getAll();
        Map<String,String> dalam = (Map<String, String>) kedalaman.getAll();
        Map<String,String> tambalan = (Map<String, String>) Tambalan.getAll();
        Map<String,String> lubang = (Map<String, String>) Lubang.getAll();
        Map<String,String> kekerasanmap = (Map<String, String>) Kekerasan.getAll();
        Map<String,String> amblas = (Map<String, String>) Amblas.getAll();

        Log.d("Hasil", "Hasil semua: "+datauser+retak1+retak2+retak3+dalam+tambalan+lubang+kekerasanmap+amblas);


        btnRetakan =findViewById(R.id.btnRetakan);
        btnRetakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataJalan.this, Retakan1.class));
            }
        });

        btnAlur = findViewById(R.id.btnAlur);
        btnAlur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataJalan.this, Alur.class));
            }
        });

        btnTambalan = findViewById(R.id.btnTambalan);
        btnTambalan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataJalan.this, Tambalan1.class));
            }
        });

        btnLubang = findViewById(R.id.btnLubang);
        btnLubang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataJalan.this, Lubang1.class));
            }
        });

        btnKekerasanPermukaan = findViewById(R.id.btnKekerasanPermukaan);
        btnKekerasanPermukaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataJalan.this, KekerasanPermukaan1.class));
            }
        });

        btnAmblas = findViewById(R.id.btnAmblas);
        btnAmblas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataJalan.this, Amblas1.class));
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

                Log.d("latlong",lattitude+longitude);




                startActivity(new Intent(InputDataJalan.this, Hasil.class));
            }
        });

        btnSaluranSamping =findViewById(R.id.btnSaluranSamping);
        btnSaluranSamping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataJalan.this, SaluranSamping1.class));
            }
        });

        btnPenghubung = findViewById(R.id.btnPenghubung);
        btnPenghubung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataJalan.this, Penghubung.class));
            }
        });

        btnBahu = findViewById(R.id.btnBahu);
        btnBahu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataJalan.this, Bahu.class));
            }
        });


        btnJalurPejalanKaki = findViewById(R.id.jalurPejalanKaki);
        btnJalurPejalanKaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataJalan.this, JalurPejalanKaki.class));
            }
        });

        btnKereb = findViewById(R.id.btnKereb);
        btnKereb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataJalan.this, Kereb.class));
            }
        });

        btnHasilD = findViewById(R.id.btnHasilD);
        btnHasilD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                    buildAlertMessageNoGps();
                }else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                    getLocation();
                }

                //Latitude longitude siap digunakan
                Log.d("latlong2 :",lattitude+", "+longitude);
                startActivity(new Intent(InputDataJalan.this, HasilDrainase.class));
            }
        });

        cbBack = findViewById(R.id.cb_back);
        cbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputDataJalan.this, UnsurfacedRoad.class));
            }
        });

    }


    private void buildAlertMessageNoGps() {


    }

    private void getLocation() {
        if(ActivityCompat.checkSelfPermission(InputDataJalan.this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(InputDataJalan.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ){

            ActivityCompat.requestPermissions(InputDataJalan.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

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
        startActivity(new Intent(InputDataJalan.this,UnsurfacedRoad.class));
    }

}
