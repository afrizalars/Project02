package com.example.zzulf.project02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import at.markushi.ui.CircleButton;

public class InputJalanURCI extends AppCompatActivity {
    CircleButton btnInput;
    EditText etNamaJalan, etTIM, etPanjang, etLebar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unsurfaced_road);

        etLebar = findViewById(R.id.et_lebar);
        etPanjang = findViewById(R.id.et_panjang);
        etTIM = findViewById(R.id.et_timsurvey);
        etNamaJalan = findViewById(R.id.et_namajalan);

        btnInput = findViewById(R.id.btn_input);
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputJalanURCI.this, URCI.class));
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        startActivity(new Intent(InputJalanURCI.this,MainMenu.class));
    }

}