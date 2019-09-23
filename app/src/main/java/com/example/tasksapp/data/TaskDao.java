package com.example.tasksapp.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM tasks")
    List<Task> getAllTasks();

    @Insert
    long insertTask(Task task);

    @Query("UPDATE tasks SET title = :title, description = :description")
    void updateTask(String title, String description);

    @Query("SELECT * FROM tasks WHERE id = :id")
    Task findPersonById(long id);
}
