package com.amadeus.feelens;

public class Task {
    private String taskName = "";
    private String taskDesc = "";
    final private int taskHeight = 250;
    private int taskNumComplete;
    //Latitude e longitude
    private double taskLat, taskLon;


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
