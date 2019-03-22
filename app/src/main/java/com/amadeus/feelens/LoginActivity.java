package com.amadeus.feelens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth firebaseAuth;

    /* Aqui também não alterei nada.
       Apenas copiei o código que recebi da última versão do projeto */
    boolean emailTrue = false, pwTrue = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        firebaseAuth = FirebaseAuth.getInstance();

        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final String strEmail = etEmail.getText().toString();
        final String strPasssword = etPassword.getText().toString();
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final String logpassError = getResources().getString(R.string.empty_login_or_password);
        final Button bRegister = (Button) findViewById(R.id.btnSignUp);




        bRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startMainFeed = new Intent(LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(startMainFeed);
                finish();

                //Checkar link com o Firebase
                Bundle params = new Bundle();
                params.putString("username", etEmail.getText().toString());
                params.putString("password", etPassword.getText().toString());
                mFirebaseAnalytics.logEvent("login_info", params);

                bLogin.setEnabled(false);
            }
        });

        etEmail.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {


                if (s.toString().equals("")) {
                    bLogin.setEnabled(false);
                    etEmail.setError(logpassError);


                } else {
                    emailTrue = true;
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if(emailTrue && pwTrue){
                    bLogin.setEnabled(true);

                }

            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {


                if (s.toString().equals("")) {
                    bLogin.setEnabled(false);
                    etPassword.setError(logpassError);


                } else{
                    pwTrue = true;
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if(emailTrue && pwTrue){
                    bLogin.setEnabled(true);

                }
            }
        });





    }
    @Override
    public void onStart(){
        super.onStart();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

    }

}
