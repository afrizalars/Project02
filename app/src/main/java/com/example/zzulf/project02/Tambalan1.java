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

public class Tambalan1 extends AppCompatActivity {

    ExpandableRelativeLayout expand1, expand2, expand3;
    Button btnUpdate1, btnDelete1, btnUpdate2, btnDelete2, btnUpdate3, btnDelete3;
    RadioGroup rgTambalan,rgTambalan2,rgTambalan3;
    RadioButton rbTambalan1, rbTambalan2, rbTambalan3;
    String Tambalan1, Tambalan2, Tambalan3;
    CircleButton cbFinish;

    Integer state=0;

    void Inisialisasi(){
        cbFinish = findViewById(R.id.cb_finish);
        rgTambalan = findViewById(R.id.rg_tambalan);
        rgTambalan2 = findViewById(R.id.rg_kedalaman_amblas2);
        rgTambalan3 = findViewById(R.id.rg_kedalaman_amblas3);

        btnUpdate1 = findViewById(R.id.btnUpdate1);
        btnUpdate2 = findViewById(R.id.btnUpdate2);
        btnUpdate3 = findViewById(R.id.btnUpdate3);
    }

    void RadioTambalan1(){
        rgTambalan = findViewById(R.id.rg_tambalan);
        int selectedId = rgTambalan.getCheckedRadioButtonId();
        rbTambalan1 = findViewById(selectedId);
        Tambalan1 = rbTambalan1.getText().toString();
        Log.d("Hasil","RadioKedalaman1"+Tambalan1);
    }

    void RadioTambalan2(){
        rgTambalan2 = findViewById(R.id.rg_tambalan2);
        int selectedId = rgTambalan2.getCheckedRadioButtonId();
        rbTambalan2 = findViewById(selectedId);
        Tambalan2 = rbTambalan2.getText().toString();
        Log.d("Hasil","RadioKedalaman2"+Tambalan2);
    }

    void RadioTambalan3(){
        rgTambalan3 = findViewById(R.id.rg_tambalan3);
        int selectedId = rgTambalan3.getCheckedRadioButtonId();
        rbTambalan3 = findViewById(selectedId);
        Tambalan3 = rbTambalan3.getText().toString();
        Log.d("Hasil","RadioKedalaman2"+Tambalan3);
    }

    void PushData(){
        final SharedPreferences Tambalan = this.getSharedPreferences("tambalan",MODE_PRIVATE);

        final SharedPreferences.Editor Editor = Tambalan.edit();


        btnUpdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioTambalan1();
                if (Tambalan1 != null){
                    Editor.putString("tambalan1",Tambalan1);
                    Editor.commit();
                } else {
                    Toast.makeText(Tambalan1.this,"Belum diisi", Toast.LENGTH_LONG);
                }

            }
        });

        btnUpdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioTambalan2();
                if (Tambalan2 != null){
                    Editor.putString("tambalan2",Tambalan2);
                    Editor.commit();
                } else {
                    Toast.makeText(Tambalan1.this,"Belum diisi", Toast.LENGTH_LONG);
                }

            }
        });

        btnUpdate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioTambalan3();
                if (Tambalan3 != null){
                    Editor.putString("tambalan3",Tambalan3);
                    Editor.commit();
                } else {
                    Toast.makeText(Tambalan1.this,"Belum diisi", Toast.LENGTH_LONG);
                }

            }
        });
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambalan1);

        Inisialisasi();
        PushData();



        state = getIntent().getIntExtra("state",0);


        cbFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iFinish = new Intent(Tambalan1.this, InputDataJalan.class);
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
        startActivity(new Intent(Tambalan1.this, InputDataJalan.class));
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        startActivity(new Intent(Tambalan1.this,InputDataJalan.class));
    }

}
