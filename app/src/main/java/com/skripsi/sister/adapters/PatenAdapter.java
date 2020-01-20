package com.skripsi.sister.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.skripsi.sister.R;
import com.skripsi.sister.models.PatenData;

import java.util.List;

public class PatenAdapter extends RecyclerView.Adapter<PatenAdapter.ViewHolder> {
    private List <PatenData> data;
    private Context context;

    public PatenAdapter(Context context) {
        this.context = context;
    }

    public List<PatenData> getData() {
        return data;
    }

    public void setData(List<PatenData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PatenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paten, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatenAdapter.ViewHolder holder, int position) {
        final PatenData patenData = getData().get(position);
        int nomor = position + 1;

        holder.tvno.setText(String.valueOf(nomor));
        holder.tvjudul.setText(patenData.getJudul());
        holder.tvjenis.setText(patenData.getJenis());
        holder.tvtglterbit.setText(patenData.getTglterbit());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout ll_paten;
        private TextView tvjudul, tvjenis, tvtglterbit, tvno;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvno = itemView.findViewById(R.id.tv_no_paten);
            ll_paten = itemView.findViewById(R.id.ll_paten);
            tvjudul = itemView.findViewById(R.id.tv_judulpaten);
            tvjenis = itemView.findViewById(R.id.tv_jenispaten);
            tvtglterbit = itemView.findViewById(R.id.tv_tglterbitpaten);
        }
    }
}

