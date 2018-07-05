package com.example.zzulf.project02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.UUID;

public class MainMenu extends AppCompatActivity {
    Button btnLogout;
    CardView btnUnsurfaced, btnSurfaced;
    String emailUser;
    String IDuser;
    FirebaseAuth mAuth;
    TextView Username;
    int k=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            emailUser = currentUser.getEmail();
        }
        IDuser = UUID.randomUUID().toString();

        SharedPreferences dataUser = this.getSharedPreferences("dataUser",MODE_PRIVATE);
        final SharedPreferences.Editor editor = dataUser.edit();
        editor.putString("email",emailUser);
        editor.putString("userid",IDuser);
        editor.commit();

        Username = findViewById(R.id.tv_username);
        Username.setText(emailUser);

        btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainMenu.this, LoginScreen.class));
            }
        });

        btnSurfaced = findViewById(R.id.btn_Surfacedroad);
        btnSurfaced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("metode","surface");
                editor.commit();
                startActivity(new Intent(MainMenu.this, UnsurfacedRoad.class));
            }
        });

        btnUnsurfaced = findViewById(R.id.btn_unsurfacedroad);
        btnUnsurfaced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("metode","unsurfaced");
                editor.commit();
                startActivity(new Intent(MainMenu.this, InputJalanURCI.class));
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        k++;
        if(k == 1)
        {
            Toast.makeText(MainMenu.this, "Tekan back sekali lagi untuk logout.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(MainMenu.this, LoginScreen.class));
            Intent i = new Intent(MainMenu.this, LoginScreen.class);
            startActivity(i);

        }
    }

}
