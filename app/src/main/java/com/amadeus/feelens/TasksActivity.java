package com.amadeus.feelens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridView;
import com.amadeus.feelens.Task;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {
    ArrayList<Task> tasksArray = new ArrayList(1);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        //TODO: Criar um loop que exiba uma nova Task enquanto houver tasks no BD.
        for(int i = 0; i < 10; i++){
            GridView newTask = new GridView(this);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(100 * i, 100);
            newTask.setLayoutParams(lp);
            newTask.setBackgroundColor(10);


        }


    }
}
