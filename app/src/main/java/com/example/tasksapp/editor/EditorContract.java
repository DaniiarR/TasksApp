package com.example.tasksapp.editor;

import com.example.tasksapp.data.Task;

public interface EditorContract {

    interface Presenter {
        void save(Task task);

        void update(Task task);

        void populate(long id);
    }

    interface View {
        void populate(Task task);
        void setPresenter(EditorContract.Presenter presenter);
    }
}
