package com.example.a01_coding;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText tvAd;
    EditText tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAd = findViewById(R.id.tvKullaniciAdi);
        tvPassword = findViewById(R.id.tvPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(btnOlay_OnClick);

    }

    View.OnClickListener btnOlay_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ShowAlert();

//            if(tvAd.getText().toString().equals("97163") && tvPassword.getText().toString().equals("123")) {
//                Snackbar snackbar = Snackbar.make(view, "Başarılı", Snackbar.LENGTH_LONG);
//                snackbar.show();
//            }
//            else{
//                Snackbar snackbar = Snackbar.make(view, "Hatalı", Snackbar.LENGTH_LONG);
//                snackbar.show();
//            }
        }
    };

    @Override
    public void onBackPressed() {
        ShowAlert();
        //Toast.makeText(this, "Geri", Toast.LENGTH_LONG).show();
    }

    void ShowAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Benimle Çıkmak");
        builder.setMessage("Benimle Çıkarmısın?");
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                finishAffinity();
            }
        });
        builder.setNegativeButton("Vazgeç", null);

        builder.create().show();
    }
}