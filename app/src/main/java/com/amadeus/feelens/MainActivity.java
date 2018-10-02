package com.amadeus.feelens;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnProfile;
    private FloatingActionButton fabMain, fabCamera, fabTask, fabSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Identificação e funcionamento do botão que envia o usuário para o seu perfil
        btnProfile = (ImageButton) findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ProfileActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        // Identificação dos FAB
        fabMain = (FloatingActionButton)findViewById(R.id.fabMain);
        fabCamera = (FloatingActionButton)findViewById(R.id.fabCamera);
        fabTask = (FloatingActionButton)findViewById(R.id.fabTask);
        fabSearch = (FloatingActionButton)findViewById(R.id.fabSearch);

    }

}
