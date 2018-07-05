package com.example.zzulf.project02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import at.markushi.ui.CircleButton;

public class Alur1 extends AppCompatActivity {

    ExpandableRelativeLayout expand1;
    RadioGroup rgKedalaman;
    CircleButton cbNext, cbAdd;

    Integer state=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alur1);


        cbAdd = findViewById(R.id.cb_addRetakan);
        cbNext = findViewById(R.id.cb_next);
        rgKedalaman = findViewById(R.id.rg_kedalaman_alur);

        state = getIntent().getIntExtra("state",0);

        if(state == 0){
            cbAdd.setVisibility(View.VISIBLE);
            cbNext.setVisibility(View.GONE);
        }
        else{
            cbAdd.setVisibility(View.GONE);
            cbNext.setVisibility(View.VISIBLE);
        }

        cbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(Alur1.this, Alur2.class);
                startActivity(iNext);
            }
        });

        cbNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(Alur1.this, Alur2.class);
                iNext.putExtra("state",1);
                startActivity(iNext);
            }
        });
    }

    public void expand1(View view) {expand1 = findViewById(R.id.expandableLayout1); expand1.toggle();}
    public void goHome(View view){
        startActivity(new Intent(Alur1.this, InputDataJalan.class));
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        startActivity(new Intent(Alur1.this,InputDataJalan.class));
    }

}
