package com.amadeus.feelens;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Task {
    private String taskName = "";
    private String taskDesc = "";
    final private int taskHeight = 250;
    private int taskNumComplete;
    private String taskCode;
    //Latitude e longitude
    private double taskLat, taskLon;






    public Task (){

    }

    public Task(String taskID){
        this.setTaskCode(taskID);
    }




    private void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    //Getters
    public int getTaskNumComplete() { return taskNumComplete;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public double getTaskLat() {
        return taskLat;
    }

    public double getTaskLon() {
        return taskLon;
    }

    public int getTaskHeight() { return taskHeight; }



}
