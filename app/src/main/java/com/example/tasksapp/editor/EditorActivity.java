package com.example.tasksapp.editor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tasksapp.R;
import com.example.tasksapp.data.AppDatabase;
import com.example.tasksapp.data.Task;

public class EditorActivity extends AppCompatActivity implements EditorContract.View{

    private EditorContract.Presenter mEditorPresenter;

    private TextView operationNameTextView;
    private EditText titleEditText;
    private EditText descriptionEditText;

    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        task = new Task();

        AppDatabase database = AppDatabase.getInMemoryDatabase(this);
        mEditorPresenter = new EditorPresenter(this, database.taskDao());

    }

    private void checkMode() {
        if (getIntent().getExtras() != null) {

        }
    }

    @Override
    public void populate(Task task) {
        this.task = task;
        titleEditText.setText(task.title);
        descriptionEditText.setText(task.description);
    }

    private void initViews() {
        operationNameTextView = findViewById(R.id.editorTitleTextView);
        titleEditText = findViewById(R.id.editorNameEditText);
        descriptionEditText = findViewById(R.id.editorDescriptionEditText);
    }
    @Override
    public void setPresenter(EditorContract.Presenter presenter) {

    }
}
