package com.amadeus.feelens;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    private FloatingActionButton fabMain, fabPerfil, fabTask, fabSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        // Identificação dos FAB
        fabMain = (FloatingActionButton)findViewById(R.id.fabMain);
        fabPerfil = (FloatingActionButton)findViewById(R.id.fabPerfil);
        fabTask = (FloatingActionButton)findViewById(R.id.fabTask);

        fabPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ProfileActivity.class);
                MainActivity.this.startActivity(i);
            }
        });


        fabTask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TasksActivity.class);
                MainActivity.this.startActivity(i);
            }
        });


    }

}
