package com.amadeus.feelens;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Random;

    public class TasksActivity extends AppCompatActivity {
    private DatabaseReference mDatabaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        //TODO: Criar um loop que exiba uma nova Task enquanto houver tasks no BD.
        //Exemplo de sintaxe do Glide:
        //Glide.with(getApplicationContext()).load("https://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Sunset_2007-1.jpg/220px-Sunset_2007-1.jpg").into(taskImage);


    }
}
