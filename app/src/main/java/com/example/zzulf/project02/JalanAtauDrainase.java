package com.example.zzulf.project02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import at.markushi.ui.CircleButton;

public class JalanAtauDrainase extends AppCompatActivity {
    CardView btnInputDataJalan, btnInputKondisiDrainase;
    CircleButton btnBack;
    TextView tvTIM, tvNamaJalan, tvLokasiJalan, tvLuasJalan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jalan_atau_drainase);

        tvLokasiJalan = findViewById(R.id.tvLokasiJalan);
        tvLuasJalan = findViewById(R.id.tvLuasJalan);
        tvNamaJalan = findViewById(R.id.tvNamaJalan);
        tvTIM = findViewById(R.id.tvTIM);

        btnInputDataJalan = findViewById(R.id.btnInputDataJalan);
        btnInputKondisiDrainase = findViewById(R.id.btnInputKondisiDrainase);
        btnBack = findViewById(R.id.btnBack);

        btnInputDataJalan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JalanAtauDrainase.this,InputDataJalan.class));
            }
        });

        btnInputKondisiDrainase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JalanAtauDrainase.this,InputDataKondisiDrainase.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JalanAtauDrainase.this,UnsurfacedRoad.class));

            }
        });

    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        startActivity(new Intent(JalanAtauDrainase.this,UnsurfacedRoad.class));
    }

}
