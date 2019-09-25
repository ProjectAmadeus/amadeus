package com.amadeus.feelens;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Task {
    public String taskName, taskDesc, taskExp;


    public Task(){

    }

    public Task(String taskName, String taskDesc, String taskExp){
        this.taskName = taskName;
        this.taskDesc = taskDesc;
        this.taskExp = taskExp;

    }


}
