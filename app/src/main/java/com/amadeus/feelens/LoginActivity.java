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

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth firebaseAuth;
    private int RC_SIGN_IN = 1;

    /* Aqui também não alterei nada.
       Apenas copiei o código que recebi da última versão do projeto */
    boolean emailTrue = false, pwTrue = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        firebaseAuth = FirebaseAuth.getInstance();


        //XML layout references
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final String strEmail = etEmail.getText().toString();
        final String strPasssword = etPassword.getText().toString();
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final String logpassError = getResources().getString(R.string.empty_login_or_password);
        final Button bRegister = (Button) findViewById(R.id.btnSignUp);

        //Code snippet taken from Google Devs to create the Ui elements
        final List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());


        //Tests if the user is signed in
        if(firebaseAuth.getCurrentUser() != null){
            Intent startMainFeed = new Intent(LoginActivity.this, MainActivity.class);
            LoginActivity.this.startActivity(startMainFeed);
        }


        bRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               //Draws the UI elements
                startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setLogo(R.drawable.ic_logo_feelens)
                        .build(),
                RC_SIGN_IN);
            }
        });


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //Redireciona para o feed principal
                    Intent startMainFeed = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(startMainFeed);
                    finish();

                    bLogin.setEnabled(false);
            }
        });

        //Checks if the text boxes are empty
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
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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
        //Returns the current user token
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
    }


    //Snippet from Google Devs example
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Intent startMainFeed = new Intent(LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(startMainFeed);


            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }




}
