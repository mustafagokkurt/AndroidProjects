package com.egitim.a03_rehber;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Kisi> alList = new ArrayList<>();
    RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*

        Kisi k = new Kisi();
        k.setAd("Ad 1");
        k.setSoyad("Soyad 1");
        k.setErkekMi(true);
        k.setePosta("asd@asd.com");
        alList.add(k);

        k = new Kisi();
        k.setAd("Ad 2");
        k.setSoyad("Soyad 2");
        k.setErkekMi(false);
        k.setePosta("asd@asd.com");
        alList.add(k);

        k = new Kisi();
        k.setAd("Ad 3");
        k.setSoyad("Soyad 3");
        k.setErkekMi(false);
        k.setePosta("asd@asd.com");
        alList.add(k);

        k = new Kisi();
        k.setAd("Ad 4");
        k.setSoyad("Soyad 4");
        k.setErkekMi(true);
        k.setePosta("asd@asd.com");
        alList.add(k);

        k = new Kisi();
        k.setAd("Ad 5");
        k.setSoyad("Soyad 5");
        k.setErkekMi(true);
        k.setePosta("asd@asd.com");
        alList.add(k);

        k = new Kisi();
        k.setAd("Ad 6");
        k.setSoyad("Soyad 6");
        k.setErkekMi(true);
        k.setePosta("asd@asd.com");
        alList.add(k);

        k = new Kisi();
        k.setAd("Ad 7");
        k.setSoyad("Soyad 7");
        k.setErkekMi(true);
        k.setePosta("asd@asd.com");
        alList.add(k);

        alList.add(k);

        k = new Kisi();
        k.setAd("Ad 8");
        k.setSoyad("Soyad 8");
        k.setErkekMi(true);
        k.setePosta("asd@asd.com");
        alList.add(k);

        k = new Kisi();
        k.setAd("Ad 8");
        k.setSoyad("Soyad 8");
        k.setErkekMi(true);
        k.setePosta("asd@asd.com");
        alList.add(k);

        k = new Kisi();
        k.setAd("Ad 8");
        k.setSoyad("Soyad 8");
        k.setErkekMi(true);
        k.setePosta("asd@asd.com");
        alList.add(k);

        k = new Kisi();
        k.setAd("Ad 8");
        k.setSoyad("Soyad 8");
        k.setErkekMi(true);
        k.setePosta("asd@asd.com");
        alList.add(k);*/

        TodoOperation todoOperation = new TodoOperation(this);



        alList = todoOperation.TumKisiGetir();

        Log.d("liste count", String.valueOf(alList.size()));

        rvList = findViewById(R.id.rvList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        rvList.addItemDecoration(dividerItemDecoration);

        rvList.setLayoutManager(layoutManager);

        RvAdapter adap = new RvAdapter(new RvClickHandler() {
            @Override
            public void onRowClicked(int position) {
                RowClicked(position);
            }

            @Override
            public void onUpdateClicked(int position) {
                UpdateClicked(position);
            }
        }, alList);
        rvList.setAdapter(adap);
    }

    void RowClicked(int position)
    {
        Toast.makeText(this, alList.get(position).getAd(), Toast.LENGTH_LONG).show();
    }

    void UpdateClicked(int position)
    {
        Intent i = new Intent(this, ActivityYeniKisi.class);
        i.putExtra("index", position);

        startActivityForResult(i, 2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK)
        {
            rvList.getAdapter().notifyDataSetChanged();
        }
        else if(requestCode == 2 && resultCode == RESULT_OK)
        {
            rvList.getAdapter().notifyDataSetChanged();
        }
    }

    public void btnYeniKisi_OnClick(View view) {

        Intent i = new Intent(this, ActivityYeniKisi.class);
        startActivityForResult(i, 1);
    }
}














