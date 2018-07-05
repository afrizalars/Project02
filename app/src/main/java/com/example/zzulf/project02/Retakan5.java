package com.example.zzulf.project02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import at.markushi.ui.CircleButton;

public class Retakan5 extends AppCompatActivity {

    ExpandableRelativeLayout expand1, expand2, expand3;
    RadioGroup rgTipe, rgLuas, rgAlur;
    CircleButton cbBack, cbFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retakan5);

        cbFinish = findViewById(R.id.cb_finish);
        cbBack = findViewById(R.id.cb_back);

        cbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack = new Intent(Retakan5.this, Retakan4.class);
                iBack.putExtra("state",1);
                startActivity(iBack);

            }
        });

        cbFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(Retakan5.this, InputDataJalan.class);
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


}
