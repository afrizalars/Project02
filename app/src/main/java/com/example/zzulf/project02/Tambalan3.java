package com.example.zzulf.project02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import at.markushi.ui.CircleButton;

public class Tambalan3 extends AppCompatActivity {
    RadioGroup rgKedalaman;
    CircleButton cbNext, cbAdd, cbBack;
    ExpandableRelativeLayout expand1;


    Integer state=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambalan3);

        cbAdd = findViewById(R.id.cb_addRetakan);
        cbNext = findViewById(R.id.cb_next);
        cbBack = findViewById(R.id.cb_back);

        state = getIntent().getIntExtra("state",0);
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
                Intent iBack =new Intent(Tambalan3.this, Tambalan2.class);
                iBack.putExtra("state",1);
                startActivity(iBack);
            }
        });

        cbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(Tambalan3.this, Tambalan4.class);
                startActivity(iNext);
            }
        });

        cbNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(Tambalan3.this, Tambalan4.class);
                iNext.putExtra("state",1);
                startActivity(iNext);
            }
        });
    }

    public void expand1(View view) {expand1 = findViewById(R.id.expandableLayout1); expand1.toggle();}
    public void goHome(View view){
        startActivity(new Intent(Tambalan3.this, InputDataJalan.class));
    }
}
