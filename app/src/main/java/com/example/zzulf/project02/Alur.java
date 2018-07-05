package com.example.zzulf.project02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import at.markushi.ui.CircleButton;

public class Alur extends AppCompatActivity {

    ExpandableRelativeLayout expand1, expand2, expand3;
    Button btnUpdate1, btnDelete1, btnUpdate2, btnDelete2, btnUpdate3, btnDelete3;
    RadioGroup rgKedalaman,rgKedalaman2,rgKedalaman3;
    RadioButton rbKedalaman1, rbKedalaman2, rbKedalaman3;
    String Kedalaman, Kedalaman2, Kedalaman3;

    Button expandableButton1,expandableButton2,expandableButton3 ;

    CircleButton cbFinish;

    Integer state=0;


    void Inisialisasi(){
        cbFinish = findViewById(R.id.cb_finish);
        rgKedalaman = findViewById(R.id.rg_kedalaman_alur);
        rgKedalaman2 = findViewById(R.id.rg_kedalaman_alur2);
        rgKedalaman3 = findViewById(R.id.rg_kedalaman_alur3);

        btnUpdate1 = findViewById(R.id.btnUpdate1);
        btnUpdate2 = findViewById(R.id.btnUpdate2);
        btnUpdate3 = findViewById(R.id.btnUpdate3);

        expandableButton1 = findViewById(R.id.expandableButton1);
        expandableButton2 = findViewById(R.id.expandableButton2);
        expandableButton3 = findViewById(R.id.expandableButton3);

    }

    void RadioKedalaman1(){
        rgKedalaman = findViewById(R.id.rg_kedalaman_alur);
        int selectedId = rgKedalaman.getCheckedRadioButtonId();
        rbKedalaman1 = findViewById(selectedId);
        Kedalaman = rbKedalaman1.getText().toString();
        Log.d("Hasil","RadioKedalaman1"+Kedalaman);
    }

    void RadioKedalaman2(){
        rgKedalaman2 = findViewById(R.id.rg_kedalaman_alur2);
        int selectedId = rgKedalaman2.getCheckedRadioButtonId();
        rbKedalaman2 = findViewById(selectedId);
        Kedalaman2 = rbKedalaman2.getText().toString();
        Log.d("Hasil","RadioKedalaman1"+Kedalaman2);
    }

    void RadioKedalaman3(){
        rgKedalaman3 = findViewById(R.id.rg_kedalaman_alur3);
        int selectedId = rgKedalaman3.getCheckedRadioButtonId();
        rbKedalaman3 = findViewById(selectedId);
        Kedalaman3 = rbKedalaman3.getText().toString();
        Log.d("Hasil","RadioKedalaman3"+Kedalaman3);
    }

    void PushData(){
        SharedPreferences kedalaman = this.getSharedPreferences("kedalaman",MODE_PRIVATE);

        final SharedPreferences.Editor Editor = kedalaman.edit();


        btnUpdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioKedalaman1();
                if (Kedalaman != null){
                    Editor.putString("kedalaman1",Kedalaman);
                    Editor.commit();
                    expandableButton1.setBackgroundColor(Color.rgb(98,212,54));
                } else {
                    Toast.makeText(Alur.this,"Belum diisi", Toast.LENGTH_LONG);
                    expandableButton1.setBackgroundColor(Color.rgb(107,22,191));
                }

            }
        });

        btnUpdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioKedalaman2();
                if (Kedalaman2 != null){
                    Editor.putString("kedalaman2",Kedalaman2);
                    Editor.commit();
                    expandableButton2.setBackgroundColor(Color.rgb(98,212,54));
                } else {
                    Toast.makeText(Alur.this,"Belum diisi", Toast.LENGTH_LONG);
                    expandableButton2.setBackgroundColor(Color.rgb(107,22,191));
                }

            }
        });

        btnUpdate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioKedalaman3();
                if (Kedalaman3 != null){
                    Editor.putString("kedalaman1",Kedalaman3);
                    Editor.commit();
                    expandableButton3.setBackgroundColor(Color.rgb(98,212,54));

                } else {
                    Toast.makeText(Alur.this,"Belum diisi", Toast.LENGTH_LONG);
                    expandableButton3.setBackgroundColor(Color.rgb(107,22,191));

                }

            }
        });
    }
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alur);

        Inisialisasi();

        PushData();


        state = getIntent().getIntExtra("state",0);


        cbFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iFinish = new Intent(Alur.this, InputDataJalan.class);
                startActivity(iFinish);
            }
        });

    }

    public void expandableButton1(View view){
        expand1 = findViewById(R.id.expandableLayout1);
        expand1.toggle();
    }

    public void expandableButton2(View view){
        expand2 = findViewById(R.id.expandableLayout2);
        expand2.toggle();
    }

    public void expandableButton3(View view){
        expand3 = findViewById(R.id.expandableLayout3);
        expand3.toggle();
    }

    public void expand1(View view) {expand1 = findViewById(R.id.expandableLayout1); expand1.toggle();}
    public void expand2(View view) {expand2 = findViewById(R.id.expandableLayout1); expand2.toggle();}
    public void expand3(View view) {expand3 = findViewById(R.id.expandableLayout1); expand3.toggle();}


    public void goHome(View view){
        startActivity(new Intent(Alur.this, InputDataJalan.class));
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        startActivity(new Intent(Alur.this,InputDataJalan.class));
    }

}
