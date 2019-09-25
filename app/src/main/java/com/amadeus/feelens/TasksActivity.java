package com.amadeus.feelens;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

    public class TasksActivity extends AppCompatActivity {
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int page = 0;
    RecyclerView myRecyclerView;
    private DatabaseReference mDatabaseRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        myRecyclerView = findViewById(R.id.task_recycler_view);
        //TODO: Criar um loop que exiba uma nova Task enquanto houver tasks no BD.
        //Exemplo de sintaxe do Glide:
        //Glide.with(getApplicationContext()).load("https://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Sunset_2007-1.jpg/220px-Sunset_2007-1.jpg").into(taskImage);

        //Referencia pro banco de dados
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        loadTasksFromFirebase();



    }

    void loadTasksFromFirebase(){
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Tasks/ids");
        mDatabaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Task newTask = dataSnapshot.getValue(Task.class);
                System.out.println("Task Name: " + newTask.taskName);
                System.out.println("Task Desc: " + newTask.taskDesc);
                System.out.println("Task Exp: " + newTask.taskExp);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
