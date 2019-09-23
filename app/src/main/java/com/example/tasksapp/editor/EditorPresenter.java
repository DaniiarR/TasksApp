package com.example.tasksapp.editor;

import com.example.tasksapp.data.Task;
import com.example.tasksapp.data.TaskDao;

public class EditorPresenter implements EditorContract.Presenter {

    private final EditorContract.View mView;
    private final TaskDao taskDao;

    public EditorPresenter(EditorContract.View mView, TaskDao taskDao) {
        this.mView = mView;
        this.taskDao = taskDao;
    }

    @Override
    public void save(Task task) {
        taskDao.insertTask(task);
    }

    @Override
    public void update(Task task) {
        taskDao.updateTask(task.title, task.description);
    }

    @Override
    public void populate(long id) {
        mView.populate(taskDao.findPersonById(id));
    }
}
