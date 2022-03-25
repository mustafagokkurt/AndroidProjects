package com.example.a02_listeler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


            setContentView(R.layout.splash);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ekraniYukle();
                }
            }, 2500);


    }

    void ekraniYukle(){
        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.lvListe);
        final ArrayList<String> alMetinler = new ArrayList<>();
        alMetinler.add("1");
        alMetinler.add("2");
        alMetinler.add("3");
        alMetinler.add("4");

        adapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, alMetinler);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,  String.valueOf(i), Toast.LENGTH_LONG).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                alMetinler.remove(i);
                adapter.notifyDataSetChanged();
                return  true;
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.etValue);
                alMetinler.add(editText.getText().toString());
            }
        });

    }
}