package com.amadeus.feelens;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.amadeus.feelens.adapters.MyPagerAdapter;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
//TODO: Remover os fragmentos ja estabelecidos e implementar as novas convencoes de design com CardView

public class ProfileActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageButton btnBack, btnSettings;
    private Button btnSignOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Código necessário para o funcionamento das abas
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), getResources().getStringArray(R.array.tab_title)));
        tabLayout.setupWithViewPager(viewPager);

        // Configuração dos botões superiores
        btnBack = (ImageButton)findViewById(R.id.imgBtnBack);
        btnSettings = (ImageButton)findViewById(R.id.imgBtnSettings);
        btnSignOut = (Button)findViewById(R.id.btnSignOut);

        // Botão para voltar
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileActivity.this, MainActivity.class);
                ProfileActivity.this.startActivity(i);
            }
        });

        // Botão para ir às configurações
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent i = new Intent(ProfileActivity.this, SettingsActivity.class);
                // ProfileActivity.this.startActivity(i);
            }
        });


        //Botão para deslogar
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });


    }

    public void signOut() {
        FirebaseAuth.getInstance().signOut();
        //Redireciona para a tela de login
        Intent returnToLogin = new Intent(ProfileActivity.this, LoginActivity.class);
        ProfileActivity.this.startActivity(returnToLogin);
    }


}



