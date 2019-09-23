package com.example.tasksapp.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasksapp.R;
import com.example.tasksapp.data.Task;

import org.w3c.dom.Text;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {

    private List<Task> taskList;

    public TasksAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);

        TaskViewHolder viewHolder = new TaskViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);

        holder.taskTitleTextView.setText(task.title);
        holder.taskDescriptionTextView.setText(task.description);

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView taskTitleTextView;
        TextView taskDescriptionTextView;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTitleTextView = itemView.findViewById(R.id.task_title_textView);
            taskDescriptionTextView = itemView.findViewById(R.id.task_description_textView);
        }
    }
}
