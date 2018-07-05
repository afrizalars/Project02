package com.example.zzulf.project02;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.wang.avi.AVLoadingIndicatorView;

public class LoginScreen extends AppCompatActivity {
    Button btnLogin, btnRegister;
    LinearLayout linearButton, linearLogin;
    AVLoadingIndicatorView loadingIndicator;
    EditText inputEmail, inputPassword;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    public int k=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        btnLogin = findViewById(R.id.btn_Login);
        btnRegister = findViewById(R.id.btn_Register);
        linearButton = findViewById(R.id.linearButton);
        linearLogin = findViewById(R.id.linearLogin);
        inputEmail = findViewById(R.id.et_email);
        inputPassword = findViewById(R.id.et_password);
        loadingIndicator = findViewById(R.id.loadingIndicator);

        loadingIndicator.hide();
        loadingIndicator.setVisibility(View.INVISIBLE);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(LoginScreen.this, MainMenu.class) );
                }
            }
        };

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginScreen.this, RegisterScreen.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearButton.setVisibility(View.GONE);
                loadingOn();
                startSignIn();
            }
        });


    }

    private void loadingOn(){
        linearButton.setVisibility(View.GONE);

        loadingIndicator.smoothToShow();
        loadingIndicator.setVisibility(View.VISIBLE);
    }

    private void loadingOff(){
        linearButton.setVisibility(View.VISIBLE);
        loadingIndicator.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);

    }

    @Override
    public void onBackPressed()
    {
        k++;
        if(k == 1)
        {
            Toast.makeText(LoginScreen.this, "Tekan back sekali lagi untuk keluar.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            this.finish();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private void startSignIn() {

        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if (TextUtils.isEmpty(email) | TextUtils.isEmpty(password)) {
            Toast.makeText(LoginScreen.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
            loadingOff();

        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {

                    if (!task.isSuccessful()) {
                        Toast.makeText(LoginScreen.this, "Login Problem", Toast.LENGTH_SHORT).show();
                        loadingOff();
                    }
                }
            });

        }

    }

}
