package com.amadeus.feelens;


import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.io.InputStream;

public class Task {
    private String taskName;
    private String taskExp;
    private String taskDesc;
    private String taskId;

    public Task() {
    }

    public Task(String taskName, String taskExp, String taskDesc, String taskId) {
        this.taskName = taskName;
        this.taskExp = taskExp;
        this.taskDesc = taskDesc;
        this.taskId = taskId;
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

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

}
