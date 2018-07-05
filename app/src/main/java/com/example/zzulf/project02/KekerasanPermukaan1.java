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

public class KekerasanPermukaan1 extends AppCompatActivity {

    ExpandableRelativeLayout expand1, expand2, expand3;
    Button btnUpdate1, btnDelete1, btnUpdate2, btnDelete2, btnUpdate3, btnDelete3;
    RadioGroup rgKekerasan,rgKekerasan2,rgKekerasan3;
    RadioButton rbKekerasan1, rbKekerasan2, rbKekerasan3;
    String Kekerasan1, Kekerasan2, Kekerasan3;
    CircleButton cbFinish;

    Integer state=0;

    void Inisialisasi(){
        cbFinish = findViewById(R.id.cb_finish);
        rgKekerasan = findViewById(R.id.rg_kedalaman_kekerasan);
        rgKekerasan2 = findViewById(R.id.rg_kedalaman_kekerasan2);
        rgKekerasan3 = findViewById(R.id.rg_kedalaman_kekerasan3);

        btnUpdate1 = findViewById(R.id.btnUpdate1);
        btnUpdate2 = findViewById(R.id.btnUpdate2);
        btnUpdate3 = findViewById(R.id.btnUpdate3);
    }

    void RadioKekerasan1(){
        rgKekerasan = findViewById(R.id.rg_kedalaman_kekerasan);
        int selectedId = rgKekerasan.getCheckedRadioButtonId();
        rbKekerasan1 = findViewById(selectedId);
        Kekerasan1 = rbKekerasan1.getText().toString();
        Log.d("Hasil","RadioKekerasan1"+Kekerasan1);
    }

    void RadioKekerasan2(){
        rgKekerasan2 = findViewById(R.id.rg_kedalaman_kekerasan2);
        int selectedId = rgKekerasan2.getCheckedRadioButtonId();
        rbKekerasan2 = findViewById(selectedId);
        Kekerasan2 = rbKekerasan2.getText().toString();
        Log.d("Hasil","RadioKekerasan2"+Kekerasan2);
    }

    void RadioKekerasan3(){
        rgKekerasan3 = findViewById(R.id.rg_kedalaman_kekerasan3);
        int selectedId = rgKekerasan3.getCheckedRadioButtonId();
        rbKekerasan3 = findViewById(selectedId);
        Kekerasan3 = rbKekerasan3.getText().toString();
        Log.d("Hasil","RadioKekerasan3"+Kekerasan3);
    }

    void PushData(){
        final SharedPreferences Kekerasan = this.getSharedPreferences("Kekerasan",MODE_PRIVATE);

        final SharedPreferences.Editor Editor = Kekerasan.edit();


        btnUpdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioKekerasan1();
                if (Kekerasan1 != null){
                    Editor.putString("kekerasan1",Kekerasan1);
                    Editor.commit();
                } else {
                    Toast.makeText(KekerasanPermukaan1.this,"Belum diisi", Toast.LENGTH_LONG);
                }

            }
        });

        btnUpdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioKekerasan2();
                if (Kekerasan2 != null){
                    Editor.putString("kekerasan2",Kekerasan2);
                    Editor.commit();
                } else {
                    Toast.makeText(KekerasanPermukaan1.this,"Belum diisi", Toast.LENGTH_LONG);
                }

            }
        });

        btnUpdate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioKekerasan3();
                if (Kekerasan3 != null){
                    Editor.putString("kekerasan3",Kekerasan3);
                    Editor.commit();
                } else {
                    Toast.makeText(KekerasanPermukaan1.this,"Belum diisi", Toast.LENGTH_LONG);
                }

            }
        });

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kekerasan_permukaan1);

        Inisialisasi();
        PushData();

        state = getIntent().getIntExtra("state",0);


        cbFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iFinish = new Intent(KekerasanPermukaan1.this, InputDataJalan.class);
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
        startActivity(new Intent(KekerasanPermukaan1.this, InputDataJalan.class));
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        startActivity(new Intent(KekerasanPermukaan1.this,InputDataJalan.class));
    }

}
