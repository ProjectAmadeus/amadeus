    package com.amadeus.feelens;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.amadeus.feelens.Task;
import com.bumptech.glide.Glide;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
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
        Random r = new Random();
        int idTest = r.nextInt(100);
        String taskRandomID = Integer.toString(idTest);
        Button btnSendTaskToFirebase = (Button) findViewById(R.id.send_task_to_firebase);
        // createNewTaskID(taskRandomID);


        //Registrando o listener para qunado a tela for scrollada
        myRecyclerView.addOnScrollListener(new PaginationScrollListener((LinearLayoutManager) myRecyclerView.getLayoutManager()) {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
            @Override
            protected void loadMoreItems() {
                if (!isLoading && !isLastPage) {
                    //TODO: criar a funcao para 'carregar' a proxima pagina
                    //loadNextPage();
                }
            }
            @Override
            public boolean isLastPage() {
                return isLastPage;
            }
            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });

        btnSendTaskToFirebase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            createNewTaskID("Nome da Task (TEST)");

            }
        });


    }


    private void createNewTaskID(String taskID) {
        Task task = new Task(taskID);
        mDatabaseRef.child("Task/id_task").child(taskID).setValue(task).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                System.out.println("Informacoes upadas com sucesso");
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Informacoes nao foram upadas com sucesso");
                    }
                });
    }
}
