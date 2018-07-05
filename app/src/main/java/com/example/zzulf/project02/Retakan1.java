package com.example.zzulf.project02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import at.markushi.ui.CircleButton;

public class Retakan1 extends AppCompatActivity {

    ExpandableRelativeLayout expand1, expand2, expand3, expand4, expand5, expand6, expand7, expand8, expand9;
    RadioGroup rgTipe, rgLebar, rgLuas, rgTipe2, rgLebar2, rgLuas2, rgTipe3, rgLebar3, rgLuas3;
    RadioButton rbTipe, rbLebar, rbLuas, rbTipe2, rbLebar2, rbLuas2, rbTipe3, rbLebar3, rbLuas3;
    String Tipe, Lebar, Luas, Tipe2, Lebar2, Luas2, Tipe3, Lebar3, Luas3;
    CircleButton cbFinish;
    Integer state=0;
    Button update, update2,update3,update4,update5,update6,update7,update8,update9;


    public void RadioSatuTipe(){
        rgTipe = findViewById(R.id.rg_tipe_retakan);
        int selectedId = rgTipe.getCheckedRadioButtonId();
        rbTipe = findViewById(selectedId);
        Tipe = rbTipe.getText().toString();
        Log.d("Hasil", "RadioSatuTipe: "+Tipe);
    }

    public void RadioSatuLuas(){
        rgLuas = findViewById(R.id.rg_luas_retakan);
        int selectedId = rgLuas.getCheckedRadioButtonId();
        rbLuas = findViewById(selectedId);
        Luas = rbLuas.getText().toString();
        Log.d("Hasil", "RadioSatuLuas:"+Luas);
    }

    public void RadioSatuLebar(){
        rgLebar = findViewById(R.id.rg_lebar_retakan);
        int selectedId = rgLebar.getCheckedRadioButtonId();
        rbLebar = findViewById(selectedId);
        Lebar = rbLebar.getText().toString();
        Log.d("Hasil", "RadioSatuLebar: "+Lebar);
    }

    public void RadioDuaTipe(){
        rgTipe2 = findViewById(R.id.rg_tipe_retakan2);
        int selectedId = rgTipe2.getCheckedRadioButtonId();
        rbTipe2 = findViewById(selectedId);
        Tipe2 = rbTipe2.getText().toString();
        Log.d("Hasil", "RadioSDuaTipe: "+Tipe2);
    }

    public void RadioDuaLuas(){
        rgLuas2 = findViewById(R.id.rg_luas_retakan2);
        int selectedId = rgLuas2.getCheckedRadioButtonId();
        rbLuas2 = findViewById(selectedId);
        Luas2 = rbLuas2.getText().toString();
        Log.d("Hasil", "RadioDuaLuas "+Luas2);
    }

    public void RadioDuaLebar(){
        rgLebar2 = findViewById(R.id.rg_lebar_retakan2);
        int selectedId = rgLebar2.getCheckedRadioButtonId();
        rbLebar2 = findViewById(selectedId);
        Lebar2 = rbLebar2.getText().toString();
        Log.d("Hasil", "RadioDuaLebar: "+Lebar2);
    }

    public void RadioTigaTipe(){
        rgTipe3 = findViewById(R.id.rg_tipe_retakan3);
        int selectedId = rgTipe3.getCheckedRadioButtonId();
        rbTipe3 = findViewById(selectedId);
        Tipe3 = rbTipe3.getText().toString();
        Log.d("Hasil", "RadioTigaTipe: "+Tipe3);
    }

    public void RadioTigaLuas(){
        rgLuas3 = findViewById(R.id.rg_luas_retakan3);
        int selectedId = rgLuas3.getCheckedRadioButtonId();
        rbLuas3 = findViewById(selectedId);
        Luas3 = rbLuas3.getText().toString();
        Log.d("Hasil", "RadioTigaLuas "+Luas3);
    }

    public void RadioTigaLebar(){
        rgLebar3 = findViewById(R.id.rg_lebar_retakan3);
        int selectedId = rgLebar3.getCheckedRadioButtonId();
        rbLebar3 = findViewById(selectedId);
        Lebar3 = rbLebar3.getText().toString();
        Log.d("Hasil", "RadioTigaLebar: "+Lebar3);
    }


    void Inisialisasi(){
        update = findViewById(R.id.btnUpdate1);
        update2 = findViewById(R.id.btnUpdate2);
        update3 = findViewById(R.id.btnUpdate3);
        update4 = findViewById(R.id.btnUpdate4);
        update5 = findViewById(R.id.btnUpdate5);
        update6 = findViewById(R.id.btnUpdate6);
        update7 = findViewById(R.id.btnUpdate7);
        update8 = findViewById(R.id.btnUpdate8);
        update9 = findViewById(R.id.btnUpdate9);

        rgTipe = findViewById(R.id.rg_tipe_retakan);
        rgTipe2 = findViewById(R.id.rg_tipe_retakan2);
        rgTipe3 = findViewById(R.id.rg_tipe_retakan3);

        rgLebar = findViewById(R.id.rg_lebar_retakan);
        rgLebar2 = findViewById(R.id.rg_lebar_retakan2);
        rgLebar3 = findViewById(R.id.rg_lebar_retakan3);

        rgLuas = findViewById(R.id.rg_luas_retakan);
        rgLuas2 = findViewById(R.id.rg_luas_retakan2);
        rgLuas3 = findViewById(R.id.rg_luas_retakan3);


        cbFinish = findViewById(R.id.cb_finish);
    }

    void PushData(){
        SharedPreferences retakan1 = this.getSharedPreferences("retakan1",MODE_PRIVATE);
        SharedPreferences retakan2 = this.getSharedPreferences("retakan2",MODE_PRIVATE);
        SharedPreferences retakan3 = this.getSharedPreferences("retakan3",MODE_PRIVATE);

        final SharedPreferences.Editor Editor1 = retakan1.edit();
        final SharedPreferences.Editor Editor2 = retakan2.edit();
        final SharedPreferences.Editor Editor3 = retakan3.edit();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioSatuTipe();
                Editor1.putString("tipe",Tipe);
            }
        });

        update2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioSatuLebar();
                Editor1.putString("lebar",Lebar);
            }
        });

        update3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioSatuLuas();
                Editor1.putString("luas",Luas);
            }
        });

        update4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioDuaTipe();

                Editor2.putString("tipe2",Tipe2);
            }
        });

        update5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioDuaLebar();

                Editor2.putString("lebar2",Lebar2);
            }
        });

        update6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioDuaLuas();
                Editor2.putString("luas2",Luas2);
            }
        });

        update7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioTigaTipe();
                Editor3.putString("tipe3",Tipe3);
            }
        });

        update8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioTigaLebar();
                Editor3.putString("lebar3",Lebar3);
            }
        });

        update9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioTigaLuas();
                Editor3.putString("luas3",Luas3);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retakan1);

        Inisialisasi();

        PushData();


        cbFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(Retakan1.this, InputDataJalan.class);
                startActivity(iNext);
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

    public void expandableButton4(View view){
        expand4 = findViewById(R.id.expandableLayout4);
        expand4.toggle();
    }

    public void expandableButton5(View view){
        expand5 = findViewById(R.id.expandableLayout5);
        expand5.toggle();
    }

    public void expandableButton6(View view){
        expand6 = findViewById(R.id.expandableLayout6);
        expand6.toggle();
    }

    public void expandableButton7(View view){
        expand7 = findViewById(R.id.expandableLayout7);
        expand7.toggle();
    }

    public void expandableButton8(View view){
        expand8 = findViewById(R.id.expandableLayout8);
        expand8.toggle();
    }

    public void expandableButton9(View view){
        expand9 = findViewById(R.id.expandableLayout9);
        expand9.toggle();
    }

    public void goHome(View view){
        startActivity(new Intent(Retakan1.this, InputDataJalan.class));
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        startActivity(new Intent(Retakan1.this,InputDataJalan.class));
    }

}
