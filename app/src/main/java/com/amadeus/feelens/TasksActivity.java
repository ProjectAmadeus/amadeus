package com.amadeus.feelens;

import android.net.Uri;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;
import java.util.Random;

    public class TasksActivity extends AppCompatActivity {
    private DatabaseReference mDatabaseRef;
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_tasks);
        new FirebaseDatabaseHelper().readTasks(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Task> tasks, List<String> keys) {
                new RecyclerViewConfig().setConfig(mRecyclerView, TasksActivity.this, tasks, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });



        //Exemplo de sintaxe do Glide:
        //Glide.with(getApplicationContext()).load("https://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Sunset_2007-1.jpg/220px-Sunset_2007-1.jpg").into(taskImage);
    }

    public static String getTaskUrl (String taskId){
        // Points to the root reference
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference taskRef = storageRef.child("/images/" + taskId + ".jpeg");
        return taskRef.toString();
    }

}
