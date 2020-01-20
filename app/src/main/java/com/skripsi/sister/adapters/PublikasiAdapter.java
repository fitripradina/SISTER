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
import com.skripsi.sister.models.PublikasiData;

import java.util.List;

public class PublikasiAdapter extends RecyclerView.Adapter<PublikasiAdapter.ViewHolder> {
    private List <PublikasiData> data;
    private Context context;

    public PublikasiAdapter(Context context) {
        this.context = context;
    }

    public List<PublikasiData> getData() {
        return data;
    }

    public void setData(List<PublikasiData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PublikasiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_publikasi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PublikasiAdapter.ViewHolder holder, int position) {
        final PublikasiData publikasiData = getData().get(position);
        int nomor = position + 1;

        holder.tvno.setText(String.valueOf(nomor));
        holder.tvjudulpublikasi.setText(publikasiData.getJudul());
        holder.tvjenispublikasi.setText(publikasiData.getJenispublikasi());
        holder.tvtglterbit.setText(publikasiData.getTglterbit());
        holder.tvasaldata.setText(publikasiData.getAsaldata());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout ll_publikasi;
        private TextView tvjudulpublikasi, tvjenispublikasi, tvtglterbit, tvno, tvasaldata;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvno = itemView.findViewById(R.id.tv_no_publikasi);
            ll_publikasi = itemView.findViewById(R.id.ll_publikasi);
            tvjudulpublikasi = itemView.findViewById(R.id.tv_judulpublikasi);
            tvjenispublikasi = itemView.findViewById(R.id.tv_jenispublikasi);
            tvtglterbit = itemView.findViewById(R.id.tv_tglterbit);
            tvasaldata = itemView.findViewById(R.id.tv_asaldata);
        }
    }
}

