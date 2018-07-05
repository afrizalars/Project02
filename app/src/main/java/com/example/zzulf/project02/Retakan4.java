package com.example.zzulf.project02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import at.markushi.ui.CircleButton;

public class Retakan4 extends AppCompatActivity {

    ExpandableRelativeLayout expand1, expand2, expand3;
    RadioGroup rgTipe, rgLuas, rgAlur;
    CircleButton cbNext, cbAdd, cbBack;
    Integer state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retakan4);

        state = getIntent().getIntExtra("state",0);

        cbNext = findViewById(R.id.cb_next);
        cbBack = findViewById(R.id.cb_back);
        cbAdd = findViewById(R.id.cb_addRetakan);

        if(state == 0){
            cbAdd.setVisibility(View.VISIBLE);
            cbNext.setVisibility(View.GONE);
        }
        else{
            cbAdd.setVisibility(View.GONE);
            cbNext.setVisibility(View.VISIBLE);
        }

        cbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack =new Intent(Retakan4.this, Retakan3.class);
                iBack.putExtra("state",1);
                startActivity(iBack);
            }
        });

        cbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iAdd = new Intent(Retakan4.this, Retakan5.class);
                startActivity(iAdd);
            }
        });

        cbNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(Retakan4.this, Retakan5.class);
                iNext.putExtra("state",1);
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

    public void goHome(View view){

        startActivity(new Intent(Retakan4.this, InputDataJalan.class));

    }
}
