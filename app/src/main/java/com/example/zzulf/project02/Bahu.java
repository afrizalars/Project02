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

import at.markushi.ui.CircleButton;

public class Bahu extends AppCompatActivity {

    ExpandableRelativeLayout expand1;
    CheckBox cbx_opt1, cbx_opt2, cbx_opt3, cbx_opt4, cbx_opt5, cbx_opt6, cbx_opt7, cbx_opt8;
    String opt1,opt2,opt3,opt4,opt5,opt6,opt7,opt8;
    CircleButton cbNext, cbAdd;
    Button btnUpdate, btnDelete;
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
            opt1 = cbx_opt1.getText().toString();
        }else{
            opt1 = null;
        }

        if(cbx_opt2.isChecked()){
            opt2 = cbx_opt2.getText().toString();
        }else{
            opt2 = null;
        }

        if(cbx_opt3.isChecked()){
            opt3 = cbx_opt3.getText().toString();
        }else{
            opt3 = null;
        }

        if(cbx_opt4.isChecked()){
            opt4 = cbx_opt4.getText().toString();
        }else{
            opt4 = null;
        }

        if(cbx_opt5.isChecked()){
            opt5 = cbx_opt5.getText().toString();
        }else{
            opt5 = null;
        }

        if(cbx_opt6.isChecked()){
            opt6 = cbx_opt6.getText().toString();
        }else{
            opt6 = null;
        }

        if(cbx_opt7.isChecked()){
            opt7 = cbx_opt7.getText().toString();
        }else{
            opt7 = null;
        }

        Log.d("Hasil","Bahu Dipilih :"+ opt1 + ", "+opt2 + ", "+opt3 + ", "+opt4 + ", "+opt5 + ", "+opt6 + ", "+opt7 + ". ");

    }
    void PushData(){
        SharedPreferences Bahu = this.getSharedPreferences("Bahu",MODE_PRIVATE);
        final SharedPreferences.Editor Editor = Bahu.edit();
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cbx_opt1.isChecked() || cbx_opt2.isChecked() || cbx_opt3.isChecked() || cbx_opt4.isChecked() || cbx_opt5.isChecked() || cbx_opt6.isChecked() || cbx_opt7.isChecked() || cbx_opt8.isChecked()  ){
                    CheckBoxGetter();
                }else{
                    Toast.makeText(Bahu.this,"Belum ada data yang dipilih",Toast.LENGTH_LONG);
                }

            }
        });

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bahu);
        Inisialisasi();
        PushData();

    }

    public void expand1(View view) {expand1 = findViewById(R.id.expandableLayout1); expand1.toggle();}

    public void goHome(View view){
        startActivity(new Intent(Bahu.this, InputDataKondisiDrainase.class));
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        startActivity(new Intent(Bahu.this,InputDataJalan.class));
    }

}
