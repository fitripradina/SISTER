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
import com.skripsi.sister.models.JabatanData;

import java.util.List;

public class JabatanAdapter extends RecyclerView.Adapter<JabatanAdapter.ViewHolder> {
    private List<JabatanData> data;
    private Context context;

    public JabatanAdapter(Context context) {
        this.context = context;
    }

    public List<JabatanData> getData() {
        return data;
    }

    public void setData(List<JabatanData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public JabatanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jabatan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JabatanAdapter.ViewHolder holder, int position) {
        final JabatanData jabatanData = getData().get(position);
        int nomor = position + 1;

        holder.tvno.setText(String.valueOf(nomor));
        holder.tvjabatan.setText(jabatanData.getJabatanfungsional());
        holder.tvnomorsk.setText(jabatanData.getNomorsk());
        holder.tvtgl.setText(jabatanData.getTerhitungtgl());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout lljabatan;
        private TextView tvjabatan, tvnomorsk, tvtgl, tvno;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lljabatan = itemView.findViewById(R.id.ll_pengabdian);
            tvjabatan = itemView.findViewById(R.id.tv_jabatan);
            tvnomorsk = itemView.findViewById(R.id.tv_nomorsk);
            tvtgl = itemView.findViewById(R.id.tv_terhitungtgl);
            tvno = itemView.findViewById(R.id.tv_no_jabatan);
        }
    }
}
