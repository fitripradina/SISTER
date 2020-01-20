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
import com.skripsi.sister.models.PengajaranData;

import java.util.List;

public class PengajaranAdapter extends RecyclerView.Adapter<PengajaranAdapter.ViewHolder> {
    private List <PengajaranData> data;
    private Context context;

    public PengajaranAdapter(Context context) {
        this.context = context;
    }

    public List<PengajaranData> getData() {
        return data;
    }

    public void setData(List<PengajaranData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PengajaranAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pengajaran, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PengajaranAdapter.ViewHolder holder, int position) {
        final PengajaranData pengajaranData = getData().get(position);
        int nomor = position + 1;

        holder.tvno.setText(String.valueOf(nomor));
        holder.tvmatkul.setText(pengajaranData.getMatakuliah());
        holder.tvkelas.setText(pengajaranData.getKelas());
        holder.tvjumlahmhs.setText(pengajaranData.getJumlahmhs());
        holder.tvsks.setText(pengajaranData.getSks());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout ll_pengajaran;
        private TextView tvmatkul, tvkelas, tvjumlahmhs, tvno, tvsks;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvno = itemView.findViewById(R.id.tv_no_pengajaran);
            ll_pengajaran = itemView.findViewById(R.id.ll_pengabdian);
            tvmatkul = itemView.findViewById(R.id.tv_matkul);
            tvkelas = itemView.findViewById(R.id.tv_kelas);
            tvjumlahmhs = itemView.findViewById(R.id.tv_jumlahmhs);
            tvsks = itemView.findViewById(R.id.tv_sks);
        }
    }
}

