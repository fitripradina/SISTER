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
import com.skripsi.sister.models.PendidikanData;

import java.util.List;

public class PendidikanAdapter extends RecyclerView.Adapter<PendidikanAdapter.ViewHolder> {
    private List <PendidikanData> data;
    private Context context;

    public PendidikanAdapter(Context context) {
        this.context = context;
    }

    public List<PendidikanData> getData() {
        return data;
    }

    public void setData(List<PendidikanData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PendidikanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pendidikan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PendidikanAdapter.ViewHolder holder, int position) {
        final PendidikanData pendidikanData = getData().get(position);
        int nomor = position + 1;

        holder.tvno.setText(String.valueOf(nomor));
        holder.tvjenjang.setText(pendidikanData.getJenjang());
        holder.tvgelar.setText(pendidikanData.getGelar());
        holder.tvbidstudi.setText(pendidikanData.getBidangstudi());
        holder.tvperguruantinggi.setText(pendidikanData.getPerguruantinggi());
        holder.tvtahunlulus.setText(pendidikanData.getTahunlulus());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout ll_pendidikan;
        private TextView tvjenjang, tvgelar, tvbidstudi, tvno, tvperguruantinggi, tvtahunlulus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvno = itemView.findViewById(R.id.tv_no_pendidikan);
            ll_pendidikan = itemView.findViewById(R.id.ll_pengabdian);
            tvjenjang = itemView.findViewById(R.id.tv_jenjang);
            tvgelar = itemView.findViewById(R.id.tv_gelar);
            tvbidstudi = itemView.findViewById(R.id.tv_bidangstudi);
            tvperguruantinggi = itemView.findViewById(R.id.tv_perguruan_tinggi);
            tvtahunlulus = itemView.findViewById(R.id.tv_tahunlulus);
        }
    }
}

