package com.egitim.a03_rehber;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvHolder> {

    ArrayList<Kisi> alList;

    private final RvClickHandler clickHandler;


    public RvAdapter(RvClickHandler clickHandler, ArrayList<Kisi> al) {
        this.clickHandler = clickHandler;
        alList = al;
    }

    @NonNull
    @Override
    public RvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;

        switch (viewType) {
            case VIEW_TYPES.Normal:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
                v.setId(0);
                break;
            case VIEW_TYPES.Header:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_header, parent, false);
                v.setId(-1);
                break;
            default:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
                v.setId(0);
                break;
        }

        return new RvHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RvHolder holder, int position) {

        if (position > 0) {
            holder.clickHandler = this.clickHandler;

            Kisi k = alList.get(position - 1);

            holder.tvNameSurname.setText(k.getAd() + " " + k.getSoyad());
            holder.tvEPosta.setText(k.getePosta());

//            if (k.getErkekMi()) {
//                holder.ivGender.setImageResource(R.mipmap.male);
//            } else {
//                holder.ivGender.setImageResource(R.mipmap.female);
//            }
        }
    }

    @Override
    public int getItemCount() {

        if(alList!= null)
            return alList.size() + 1;

        return 0;
    }

    private class VIEW_TYPES {
        public static final int Header = 1;
        public static final int Normal = 2;
    }

    @Override
    public int getItemViewType(int position) {

        if(position == 0)
            return VIEW_TYPES.Header;
        else
            return VIEW_TYPES.Normal;

    }
}
