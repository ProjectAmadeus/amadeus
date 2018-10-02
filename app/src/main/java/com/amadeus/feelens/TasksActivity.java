package com.amadeus.feelens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {
    ArrayList<Task> tasks = new ArrayList(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        //TODO: Criar um loop que exiba uma nova Task enquanto houver tasks no BD.



    }
}
