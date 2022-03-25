package com.example.a03_recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class RvHolder extends RecyclerView.ViewHolder {

    TextView tvAd;
    TextView tvSoyad;
    TextView tvMail;
    ImageView img;

    public RvClickHandler clickHandler;

    public RvHolder(@NonNull View itemView) {

        super(itemView);
        tvAd = itemView.findViewById(R.id.tvAd);
        tvMail = itemView.findViewById(R.id.tvMail);
        img = itemView.findViewById(R.id.imgFoto);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickHandler.onRowClicked(getAdapterPosition() - 1);
            }
        });
    }
}
