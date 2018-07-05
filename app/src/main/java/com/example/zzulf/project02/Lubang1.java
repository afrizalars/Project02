package com.example.zzulf.project02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import at.markushi.ui.CircleButton;

public class Lubang1 extends AppCompatActivity {

    ExpandableRelativeLayout expand1, expand2, expand3;
    Button btnUpdate1, btnDelete1, btnUpdate2, btnDelete2, btnUpdate3, btnDelete3;
    RadioGroup rgLubang,rgLubang2,rgLubang3;
    RadioButton rbLubang1, rbLubang2, rbLubang3;
    String Lubang1, Lubang2, Lubang3;
    CircleButton cbFinish;

    Integer state=0;

    void Inisialisasi(){
        cbFinish = findViewById(R.id.cb_finish);
        rgLubang = findViewById(R.id.rg_kedalaman_lubang);
        rgLubang2 = findViewById(R.id.rg_kedalaman_lubang2);
        rgLubang3 = findViewById(R.id.rg_kedalaman_lubang3);

        btnUpdate1 = findViewById(R.id.btnUpdate1);
        btnUpdate2 = findViewById(R.id.btnUpdate2);
        btnUpdate3 = findViewById(R.id.btnUpdate3);
    }

    void RadioLubang1(){
        rgLubang = findViewById(R.id.rg_kedalaman_lubang);
        int selectedId = rgLubang.getCheckedRadioButtonId();
        rbLubang1 = findViewById(selectedId);
        Lubang1 = rbLubang1.getText().toString();
        Log.d("Hasil","RadioLubang1"+Lubang1);
    }
    void RadioLubang2(){
        rgLubang2 = findViewById(R.id.rg_kedalaman_lubang2);
        int selectedId = rgLubang2.getCheckedRadioButtonId();
        rbLubang2 = findViewById(selectedId);
        Lubang2 = rbLubang2.getText().toString();
        Log.d("Hasil","RadioLubang2"+Lubang2);
    }
    void RadioLubang3(){
        rgLubang3 = findViewById(R.id.rg_kedalaman_lubang3);
        int selectedId = rgLubang3.getCheckedRadioButtonId();
        rbLubang3 = findViewById(selectedId);
        Lubang3 = rbLubang3.getText().toString();
        Log.d("Hasil","RadioLubang3"+Lubang3);
    }

    void PushData(){
        final SharedPreferences Lubang = this.getSharedPreferences("Lubang",MODE_PRIVATE);

        final SharedPreferences.Editor Editor = Lubang.edit();


        btnUpdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioLubang1();
                if (Lubang1 != null){
                    Editor.putString("lubang1",Lubang1);
                    Editor.commit();
                } else {
                    Toast.makeText(Lubang1.this,"Belum diisi", Toast.LENGTH_LONG);
                }

            }
        });

        btnUpdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioLubang2();
                if (Lubang2 != null){
                    Editor.putString("lubang2",Lubang2);
                    Editor.commit();
                } else {
                    Toast.makeText(Lubang1.this,"Belum diisi", Toast.LENGTH_LONG);
                }

            }
        });

        btnUpdate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioLubang3();
                if (Lubang3 != null){
                    Editor.putString("lubang3",Lubang3);
                    Editor.commit();
                } else {
                    Toast.makeText(Lubang1.this,"Belum diisi", Toast.LENGTH_LONG);
                }

            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lubang1);


        Inisialisasi();
        PushData();

        state = getIntent().getIntExtra("state",0);


        cbFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iFinish = new Intent(Lubang1.this, InputDataJalan.class);
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
        startActivity(new Intent(Lubang1.this, InputDataJalan.class));
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        startActivity(new Intent(Lubang1.this,InputDataJalan.class));
    }

}
