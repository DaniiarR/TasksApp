package com.example.tasksapp.data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")
public class Task {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;

    public String description;

    public Task(int id, String title, String description) {
        this.id = id;
        this.description = description;
        this.title = title;
    }

    @Ignore
    public Task() {
        this.title = "";
        this.description = "";
    }



}
