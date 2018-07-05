package com.example.zzulf.project02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import at.markushi.ui.CircleButton;

public class Amblas4 extends AppCompatActivity {
    RadioGroup rgKedalaman;
    CircleButton cbNext, cbAdd, cbBack;
    ExpandableRelativeLayout expand1;


    Integer state=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amblas4);

        cbAdd = findViewById(R.id.cb_addRetakan);
        cbNext = findViewById(R.id.cb_next);
        cbBack = findViewById(R.id.cb_back);
        rgKedalaman = findViewById(R.id.rg_kedalaman_amblas);


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
                Intent iBack =new Intent(Amblas4.this, Amblas3.class);
                iBack.putExtra("state",1);
                startActivity(iBack);
            }
        });

        cbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(Amblas4.this, Amblas5.class);
                startActivity(iNext);
            }
        });

        cbNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(Amblas4.this, Amblas5.class);
                iNext.putExtra("state",1);
                startActivity(iNext);
            }
        });
    }

    public void expand1(View view) {expand1 = findViewById(R.id.expandableLayout1); expand1.toggle();}
    public void goHome(View view){
        startActivity(new Intent(Amblas4.this, InputDataJalan.class));
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        startActivity(new Intent(Amblas4.this,Amblas3.class));
    }

}
