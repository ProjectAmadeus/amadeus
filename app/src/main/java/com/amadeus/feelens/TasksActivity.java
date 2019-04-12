package com.amadeus.feelens;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.amadeus.feelens.Task;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {
    ArrayList<Task> tasksArray = new ArrayList(1);
    final ImageView taskImage = (ImageView) findViewById(R.id.TaskSunsetTest);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        //TODO: Criar um loop que exiba uma nova Task enquanto houver tasks no BD.

        Glide.with(getApplicationContext()).load("https://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Sunset_2007-1.jpg/220px-Sunset_2007-1.jpg").into(taskImage);


    }
}
