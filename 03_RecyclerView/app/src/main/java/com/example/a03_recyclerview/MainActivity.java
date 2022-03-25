package com.example.a03_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Person> alList = new ArrayList<>();

        for (int i=0; i<15; i++){
        Person person = new Person();
        person.Adi = "Mustafa";
        person.Soyadi= "Gökkurt";
        person.Mail = "a@g.com";
        person.Cinsiyet="E";
        alList.add(person);
        }

//        Person person2 = new Person();
//        person.Adi = "Mustafa";
//        person.Soyadi= "Gökkurt";
//        person.Mail = "a@g.com";
//        person.Cinsiyet="E";
//        alList.add(person2);
//
//        Person person3 = new Person();
//        person.Adi = "Mustafa";
//        person.Soyadi= "Gökkurt";
//        person.Mail = "a@g.com";
//        person.Cinsiyet="E";
//        alList.add(person3);
//
//        Person person4 = new Person();
//        person.Adi = "Mustafa";
//        person.Soyadi= "Gökkurt";
//        person.Mail = "a@g.com";
//        person.Cinsiyet="E";
//        alList.add(person4);


        RecyclerView rv = findViewById(R.id.rvListe);

        DividerItemDecoration divider = new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.horizontal));
        rv.addItemDecoration(divider);

        RvAdapter adapter = new RvAdapter(alList);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        lm.scrollToPosition(0);

        rv.setHasFixedSize(true);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setLayoutManager(lm);

        rv.setAdapter(adapter);
    }
}