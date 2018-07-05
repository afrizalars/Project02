package com.example.zzulf.project02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;

import at.markushi.ui.CircleButton;

public class SaluranSamping1 extends AppCompatActivity {

    ExpandableRelativeLayout expand1;
    CheckBox cbx_opt1, cbx_opt2, cbx_opt3, cbx_opt4, cbx_opt5, cbx_opt6, cbx_opt7, cbx_opt8;
    Button btnUpdate, btnDelete;
    String SaluranSamping1, SaluranSamping2, SaluranSamping3, SaluranSamping4,SaluranSamping5, SaluranSamping6,SaluranSamping7, SaluranSamping8;
    CircleButton cbNext, cbAdd;

    Integer state=0;

    void Inisialisasi(){
        cbx_opt1 = findViewById(R.id.chb_opt1);
        cbx_opt2 = findViewById(R.id.chb_opt2);
        cbx_opt3 = findViewById(R.id.chb_opt3);
        cbx_opt4 = findViewById(R.id.chb_opt4);
        cbx_opt5 = findViewById(R.id.chb_opt5);
        cbx_opt6 = findViewById(R.id.chb_opt6);
        cbx_opt7 = findViewById(R.id.chb_opt7);
        cbx_opt8 = findViewById(R.id.chb_opt8);
        btnUpdate = findViewById(R.id.btnUpdate3);
        btnDelete = findViewById(R.id.btnDelete3);

    }
    void CheckBoxGetter(){

        if(cbx_opt1.isChecked()){
            SaluranSamping1 = cbx_opt1.getText().toString();
        }else{
            SaluranSamping1 = null;
        }

        if(cbx_opt2.isChecked()){
            SaluranSamping2 = cbx_opt2.getText().toString();
        }else{
            SaluranSamping2 = null;
        }

        if(cbx_opt3.isChecked()){
            SaluranSamping3 = cbx_opt3.getText().toString();
        }else{
            SaluranSamping3 = null;
        }

        if(cbx_opt4.isChecked()){
            SaluranSamping4 = cbx_opt4.getText().toString();
        }else{
            SaluranSamping4 = null;
        }

        if(cbx_opt5.isChecked()){
            SaluranSamping5 = cbx_opt5.getText().toString();
        }else{
            SaluranSamping5 = null;
        }

        if(cbx_opt6.isChecked()){
            SaluranSamping6 = cbx_opt6.getText().toString();
        }else{
            SaluranSamping6 = null;
        }

        if(cbx_opt7.isChecked()){
            SaluranSamping7 = cbx_opt7.getText().toString();
        }else{
            SaluranSamping7 = null;
        }

        if(cbx_opt8.isChecked()){
            SaluranSamping8 = cbx_opt8.getText().toString();
        }else{
            SaluranSamping8 = null;
        }

        Log.d("Hasil","Saluran Samping Dipilih :"+ SaluranSamping1 + ", "+SaluranSamping2 + ", "+SaluranSamping3 + ", "+SaluranSamping4 + ", "+SaluranSamping5 + ", "+SaluranSamping6 + ", "+SaluranSamping7 + ", "+SaluranSamping8 + ". ");

    }
    void PushData(){
        SharedPreferences SaluranSamping = this.getSharedPreferences("SaluranSamping",MODE_PRIVATE);
        final SharedPreferences.Editor Editor = SaluranSamping.edit();
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if(cbx_opt1.isChecked() || cbx_opt2.isChecked() || cbx_opt3.isChecked() || cbx_opt4.isChecked() || cbx_opt5.isChecked() || cbx_opt6.isChecked() || cbx_opt7.isChecked() || cbx_opt8.isChecked()  ){
                CheckBoxGetter();
            }else{
                Toast.makeText(SaluranSamping1.this,"Belum ada data yang dipilih",Toast.LENGTH_LONG);
            }

            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saluran_samping1);

        Inisialisasi();
        PushData();

    }

    public void goHome(View view){
        startActivity(new Intent(SaluranSamping1.this, InputDataJalan.class));
    }
}
