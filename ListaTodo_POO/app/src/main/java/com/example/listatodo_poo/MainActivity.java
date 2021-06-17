package com.example.listatodo_poo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> itens;
    private ArrayAdapter<String> itensAdapter;
    private ListView list_todo;
    private Button btnAdd;
    //private EditText editItem;
    private TextInputEditText editItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_todo = findViewById(R.id.list_todo);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });

        itens = new ArrayList<>();
        itensAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itens);
        list_todo.setAdapter( itensAdapter );

        removeItem();
    }

    private void removeItem() {

        list_todo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getApplicationContext();
                Toast.makeText(context,"Tarefa removida!", Toast.LENGTH_LONG).show();

                itens.remove(position);
                itensAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addItem(View view) {

        editItem = findViewById(R.id.editItem);
        String itemText = editItem.getText().toString();

        if(!(itemText.equals(""))){
            itensAdapter.add(itemText);
            editItem.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "Por favor insira uma tarefa.", Toast.LENGTH_LONG).show();
        }
    }
}