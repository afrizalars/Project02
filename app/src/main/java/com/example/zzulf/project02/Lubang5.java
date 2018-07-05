package com.example.zzulf.project02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import at.markushi.ui.CircleButton;

public class Lubang5 extends AppCompatActivity {

    RadioGroup rgTipe, rgLuas, rgAlur;
    CircleButton cbBack, cbFinish;
    ExpandableRelativeLayout expand1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lubang5);

        cbFinish = findViewById(R.id.cb_finish);
        cbBack = findViewById(R.id.cb_back);

        cbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack = new Intent(Lubang5.this, Lubang4.class);
                iBack.putExtra("state",1);
                startActivity(iBack);

            }
        });

        cbFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(Lubang5.this, InputDataJalan.class);
                startActivity(iNext);
            }
        });

    }

    public void expand1(View view) {expand1 = findViewById(R.id.expandableLayout1); expand1.toggle();}


}
