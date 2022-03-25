package com.example.a09_sharable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_paylas(View view) {

        Intent share = new Intent();
        share.setAction(Intent.ACTION_SEND);
        share.putExtra(Intent.EXTRA_SUBJECT, "Paylaşım Başlık");
        share.putExtra(Intent.EXTRA_TEXT, "İçerik");
        share.setType("text/plain");
        startActivity(Intent.createChooser(share, "Uygulama Seçiniz"));
    }
}