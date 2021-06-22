package com.example.listatodo_poo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.example.listatodo_poo.MainActivity;
import com.example.listatodo_poo.R;
import com.example.listatodo_poo.model.ToDoModel;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {

    private List<ToDoModel> todoList;
    private MainActivity activity;

    public ToDoAdapter(MainActivity activity){
        this.activity = activity;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tarefa_layout,parent,false);
        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        ToDoModel item = todoList.get(position);
        holder.tarefa.setText(item.getTarefa());
        holder.tarefa.setChecked(toBoolean(item.getStatus()));
    }

    public int getItemCount(){
        return todoList.size();
    }

    private boolean toBoolean(int n){
        return n!=0;
    }

    public void setTarefas(List<ToDoModel> todoList){
        this.todoList = todoList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox tarefa;

        ViewHolder(View view){
            super(view);
            tarefa = view.findViewById(R.id.todoCheckBox);
        }
    }
}
