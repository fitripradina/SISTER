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
import com.skripsi.sister.models.PengabdianData;

import java.util.List;

public class PengabdianAdapter extends RecyclerView.Adapter<PengabdianAdapter.ViewHolder> {
    private List <PengabdianData> data;
    private Context context;

    public PengabdianAdapter(Context context) {
        this.context = context;
    }

    public List<PengabdianData> getData() {
        return data;
    }

    public void setData(List<PengabdianData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PengabdianAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pengabdian, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PengabdianAdapter.ViewHolder holder, int position) {
        final PengabdianData pengabdianData = getData().get(position);
        int nomor = position + 1;

        holder.tvno.setText(String.valueOf(nomor));
        holder.tvJudulPengabdian.setText(pengabdianData.getJudul());
        holder.tvSkimPengabdian.setText(pengabdianData.getSkim());
        holder.tvTglPelaksanaan.setText(pengabdianData.getThnpelaksanaan());
        holder.tvLamaKegiatan.setText(pengabdianData.getLamakegiatan());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout ll_pengabdian;
        private TextView tvJudulPengabdian, tvSkimPengabdian, tvTglPelaksanaan, tvLamaKegiatan, tvno;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvno = itemView.findViewById(R.id.tv_no_pengabdian);
            ll_pengabdian = itemView.findViewById(R.id.ll_pengabdian);
            tvJudulPengabdian = itemView.findViewById(R.id.tv_judulpengabdian);
            tvSkimPengabdian = itemView.findViewById(R.id.tv_skimpengabdian);
            tvTglPelaksanaan = itemView.findViewById(R.id.tv_thnpenelitian);
            tvLamaKegiatan = itemView.findViewById(R.id.tv_lamapenelitian);
        }
    }
}

