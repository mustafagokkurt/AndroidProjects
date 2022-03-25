package com.egitim.a03_rehber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityYeniKisi extends AppCompatActivity {

    EditText etAd, etSoyad, etEPosta;
    Spinner spCinsiyet;

    Kisi k = null;
    Boolean yeniKisiMi = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni_kisi);

        etAd = findViewById(R.id.etAd);
        etSoyad = findViewById(R.id.etSoyad);
        etEPosta = findViewById(R.id.etEPosta);
        spCinsiyet = findViewById(R.id.spCinsiyet);

        spCinsiyet.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, new String[]{"Erkek", "Kadın"}));

        Intent i = getIntent();
        int index = i.getIntExtra("index", -1);

        if(index == -1)
        {
            k = new Kisi();
        }
        else
        {
            yeniKisiMi = false;
            k = MainActivity.alList.get(index);

            etAd.setText(k.getAd());
            etSoyad.setText(k.getSoyad());
            etEPosta.setText(k.getePosta());
            spCinsiyet = findViewById(R.id.spCinsiyet);

            //spCinsiyet.setSelection(k.getErkekMi() ? 0 : 1);
        }
    }

    public void Add_OnClick(View v)
    {
        String requiredMessage = RequiredControl();

        if(requiredMessage.isEmpty()) {

            k.setAd(etAd.getText().toString());
            k.setSoyad(etSoyad.getText().toString());
            k.setePosta(etEPosta.getText().toString());
            k.setErkekMi(spCinsiyet.getSelectedItemPosition() == 0);

            if (yeniKisiMi)
            {
                TodoOperation todoOperation = new TodoOperation(this);
                todoOperation.Ekle(k);
                MainActivity.alList = todoOperation.TumKisiGetir();
            }
            else {
                TodoOperation todoOperation = new TodoOperation(this);
                todoOperation.Guncelle(k);
                MainActivity.alList = todoOperation.TumKisiGetir();

            }

            setResult(RESULT_OK);
            finish();
        }
        else
        {
            ShowAlert(requiredMessage);
        }
    }

    String RequiredControl()
    {
        String message = "";

        if(etAd.getText().toString().isEmpty())
            message += "\nAd boş olamaz";

        if(etSoyad.getText().toString().isEmpty())
            message += "\nSoyad boş olamaz";

        if(etEPosta.getText().toString().isEmpty())
            message += "\nEPosta boş olamaz";

        return message;
    }

    void ShowAlert(String message)
    {
        AlertDialog.Builder adb = new AlertDialog.Builder(ActivityYeniKisi.this);

        adb.setTitle("Uyarı");
        adb.setMessage(message);
        adb.setPositiveButton("Tamam", null);
        adb.setCancelable(false);
        AlertDialog ad = adb.create();

        ad.show();
    }
}
