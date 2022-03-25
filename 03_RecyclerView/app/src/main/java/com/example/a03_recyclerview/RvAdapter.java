package com.example.a03_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RvAdapter extends RecyclerView.Adapter<RvHolder> {

    ArrayList<Person> alList;

    public RvAdapter(ArrayList<Person> liste){
        alList = liste;
    }

    @NonNull
    @Override
    public RvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        RvHolder rv= new RvHolder(v);

        return rv;
    }

    @Override
    public void onBindViewHolder(@NonNull RvHolder holder, int position) {
        holder.tvAd.setText(alList.get(position).Adi);

        holder.tvMail.setText(alList.get(position).Mail);
        holder.tvAd.setText(alList.get(position).Adi);

        if(alList.get(position).Cinsiyet == "E"){
            holder.img.setImageResource(R.mipmap.male);
        }
        else{
            holder.img.setImageResource(R.mipmap.female);
        }
    }

    @Override
    public int getItemCount() {
        if (alList != null)
            return alList.size();

        return 0;
    }
}
