package com.example.a09_sharable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        TextView tvBaslik = findViewById(R.id.textView);
        TextView tvIcerik = findViewById(R.id.textView2);

        Intent gelen = getIntent();
        tvBaslik.setText(gelen.getStringExtra(Intent.EXTRA_SUBJECT));
        tvIcerik.setText(gelen.getStringExtra(Intent.EXTRA_TEXT));
    }
}
