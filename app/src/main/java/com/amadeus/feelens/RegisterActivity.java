package com.amadeus.feelens;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Button bRegister = (Button) findViewById(R.id.bRegister);

        // Informações a serem importadas no banco de dados
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        mAuth = FirebaseAuth.getInstance();

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                //Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });



        

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }



}

