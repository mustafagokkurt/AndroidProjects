package com.egitim.a03_rehber;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RvHolder extends RecyclerView.ViewHolder {

    ImageView ivGender;
    TextView tvNameSurname, tvEPosta;

    ImageButton ibUpdate;

    public RvClickHandler clickHandler;

    @SuppressLint("ResourceType")
    public RvHolder(@NonNull View itemView) {
        super(itemView);

        if (itemView.getId() == 0)
        {
            ivGender = itemView.findViewById(R.id.ivListItemProfile);
            tvNameSurname = itemView.findViewById(R.id.tvListItemAdSoyad);
            tvEPosta = itemView.findViewById(R.id.tvListItemEPosta);
            ibUpdate = itemView.findViewById(R.id.ibUpdate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    clickHandler.onRowClicked(getAdapterPosition() -1);
                }
            });

            ibUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    clickHandler.onUpdateClicked(getAdapterPosition() -1);
                }
            });
        }
    }
}
