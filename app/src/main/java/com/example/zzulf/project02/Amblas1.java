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

public class Amblas1 extends AppCompatActivity {

    ExpandableRelativeLayout expand1, expand2, expand3;
    Button btnUpdate1, btnDelete1, btnUpdate2, btnDelete2, btnUpdate3, btnDelete3;
    RadioGroup rgAmblas,rgAmblas2,rgAmblas3;
    RadioButton rbAmblas, rbAmblas2, rbAmblas3;
    String Amblas1, Amblas2, Amblas3;
    CircleButton cbFinish;

    Integer state=0;

    void Inisialisasi(){

        cbFinish = findViewById(R.id.cb_finish);
        rgAmblas = findViewById(R.id.rg_kedalaman_amblas);

        btnUpdate1 = findViewById(R.id.btnUpdate1);
        btnUpdate2 = findViewById(R.id.btnUpdate2);
        btnUpdate3 = findViewById(R.id.btnUpdate3);
    }

    void RadioAmblas1(){
        rgAmblas = findViewById(R.id.rg_kedalaman_amblas);
        int selectedId = rgAmblas.getCheckedRadioButtonId();
        rbAmblas = findViewById(selectedId);
        Amblas1 = rbAmblas.getText().toString();
        Log.d("Hasil","RadioAmblas1"+Amblas1);
    }

    void RadioAmblas2(){
        rgAmblas2 = findViewById(R.id.rg_kedalaman_amblas2);
        int selectedId = rgAmblas2.getCheckedRadioButtonId();
        rbAmblas2 = findViewById(selectedId);
        Amblas2 = rbAmblas2.getText().toString();
        Log.d("Hasil","RadioAmblas2"+Amblas2);
    }

    void RadioAmblas3(){
        rgAmblas3 = findViewById(R.id.rg_kedalaman_amblas3);
        int selectedId = rgAmblas3.getCheckedRadioButtonId();
        rbAmblas3 = findViewById(selectedId);
        Amblas3 = rbAmblas3.getText().toString();
        Log.d("Hasil","RadioAmblas3"+Amblas3);
    }

    void PushData(){
        final SharedPreferences Amblas = this.getSharedPreferences("Amblas",MODE_PRIVATE);

        final SharedPreferences.Editor Editor = Amblas.edit();


        btnUpdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioAmblas1();
                if (Amblas != null){
                    Editor.putString("amblas1",Amblas1);
                    Editor.commit();
                } else {
                    Toast.makeText(Amblas1.this,"Belum diisi", Toast.LENGTH_LONG);
                }
            }
        });

        btnUpdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioAmblas2();
                if (Amblas2 != null){
                    Editor.putString("amblas2",Amblas2);
                    Editor.commit();
                } else {
                    Toast.makeText(Amblas1.this,"Belum diisi", Toast.LENGTH_LONG);
                }
            }
        });

        btnUpdate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioAmblas3();
                if (Amblas3 != null){
                    Editor.putString("amblas3",Amblas3);
                    Editor.commit();
                } else {
                    Toast.makeText(Amblas1.this,"Belum diisi", Toast.LENGTH_LONG);
                }
            }
        });

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amblas1);

        Inisialisasi();
        PushData();


        state = getIntent().getIntExtra("state",0);


        cbFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iFinish = new Intent(Amblas1.this, InputDataJalan.class);
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
        startActivity(new Intent(Amblas1.this, InputDataJalan.class));
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        startActivity(new Intent(Amblas1.this,InputDataJalan.class));
    }

}
