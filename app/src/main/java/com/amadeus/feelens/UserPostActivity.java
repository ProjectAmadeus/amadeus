package com.amadeus.feelens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class UserPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_post);

        Spinner taskSpinner = (Spinner) findViewById(R.id.spinner_tasks);
        String[] spinnerTasks = new String[]{"Mooca Burger", "Casarão do Vinil"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerTasks);
        taskSpinner.setAdapter(adapter);



    }
}
