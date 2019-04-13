package com.amadeus.feelens;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.amadeus.feelens.Task;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int page = 0;
    RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        myRecyclerView = findViewById(R.id.task_recycler_view);
        //TODO: Criar um loop que exiba uma nova Task enquanto houver tasks no BD.
        //Exemplo de sintaxe do Glide:
        //Glide.with(getApplicationContext()).load("https://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Sunset_2007-1.jpg/220px-Sunset_2007-1.jpg").into(taskImage);


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
    }
}
