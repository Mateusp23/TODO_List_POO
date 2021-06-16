package com.example.listatodo_poo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> itens;
    private ArrayAdapter<String> itensAdapter;
    private ListView list_todo;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_todo = findViewById(R.id.list_todo);
        btnAdd = findViewById(R.id.btnAdd);

    }

    private void enviarTarefa(View view){
        
    }
}