package com.example.listatodo_poo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listatodo_poo.Adapter.ToDoAdapter;
import com.example.listatodo_poo.model.ToDoModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTarefas;
    private ToDoAdapter tarefasAdapter;

    private List<ToDoModel> tarefasList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        tarefasList = new ArrayList<>();

        rvTarefas = findViewById(R.id.rvTarefas);
        rvTarefas.setLayoutManager(new LinearLayoutManager(this));

        tarefasAdapter = new ToDoAdapter(this);
        rvTarefas.setAdapter(tarefasAdapter);

        ToDoModel tarefas = new ToDoModel();
        tarefas.setTarefa("testando tarefda");
        tarefas.setStatus(0);
        tarefas.setId(1);

        tarefasList.add(tarefas);
        tarefasList.add(tarefas);
        tarefasList.add(tarefas);
        tarefasList.add(tarefas);
        tarefasList.add(tarefas);
        tarefasList.add(tarefas);
        tarefasList.add(tarefas);
        tarefasList.add(tarefas);

        tarefasAdapter.setTarefas(tarefasList);
    }
}