package com.amadeus.feelens;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.amadeus.feelens.adapters.MyPagerAdapter;

public class ProfileActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageButton btnBack, btnSettings;


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
    }
}
