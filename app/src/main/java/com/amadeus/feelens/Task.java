package com.amadeus.feelens;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Task {
    private String taskName;
    private String taskExp;
    private String taskDesc;

    public Task() {
    }

    public Task(String taskName, String taskExp, String taskDesc) {
        this.taskName = taskName;
        this.taskExp = taskExp;
        this.taskDesc = taskDesc;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskExp() {
        return taskExp;
    }

    public void setTaskExp(String taskExp) {
        this.taskExp = taskExp;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }
}
