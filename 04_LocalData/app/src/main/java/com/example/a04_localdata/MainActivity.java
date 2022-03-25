package com.example.a04_localdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedYaz();
        String okunanDeger = SharedOku();
        Log.d("Deger", okunanDeger);
    }

    void SharedYaz(){
        SharedPreferences pref = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("DegerKey", "Metin");
        editor.commit();
    }

    String SharedOku(){
        SharedPreferences pref = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        return pref.getString("DegerKey", "gg");
    }
}