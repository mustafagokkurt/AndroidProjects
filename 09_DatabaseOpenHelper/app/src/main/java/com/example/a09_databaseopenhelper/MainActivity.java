package com.example.a09_databaseopenhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TodoOperation todoOperation = new TodoOperation(this);

        Todo t = new Todo();
        t.setTitle("Title 1");
        t.setDetail("Detay 1");

        todoOperation.Ekle(t);

        ArrayList<Todo> list = todoOperation.TumTodoGetir();

        Log.d("liste count", String.valueOf(list.size()));

    }
}