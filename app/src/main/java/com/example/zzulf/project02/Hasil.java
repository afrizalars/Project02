package com.example.zzulf.project02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Hasil extends AppCompatActivity {
    Button btnHome,btnBack;
    TextView tvNamaJalan, tvKondisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        tvKondisi = findViewById(R.id.tv_Kondisi);
        tvNamaJalan = findViewById(R.id.tv_NamaJalan);
        btnBack = findViewById(R.id.btn_Back);
        btnHome = findViewById(R.id.btn_Home);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hasil.this,InputDataJalan.class));
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hasil.this,MainMenu.class));
            }
        });
    }
}
