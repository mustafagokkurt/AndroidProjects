package com.example.a09_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick_Btn1(View view) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();

        Fragment1 f1 = new Fragment1();

        ft.replace(R.id.fragCont, f1);
        ft.commit();
    }

    public void OnClick_Btn2(View view) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();

        Fragment2 f2 = new Fragment2();

        ft.replace(R.id.fragCont, f2);
        ft.commit();
    }
}