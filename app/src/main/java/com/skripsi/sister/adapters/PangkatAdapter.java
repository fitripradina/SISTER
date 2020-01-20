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
import com.skripsi.sister.models.PangkatData;

import java.util.List;

public class PangkatAdapter extends RecyclerView.Adapter<PangkatAdapter.ViewHolder> {
    private List <PangkatData> data;
    private Context context;

    public PangkatAdapter(Context context) {
        this.context = context;
    }

    public List<PangkatData> getData() {
        return data;
    }

    public void setData(List<PangkatData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PangkatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kepangkatan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PangkatAdapter.ViewHolder holder, int position) {
        final PangkatData pangkatData = getData().get(position);
        int nomor = position + 1;

        holder.tvno.setText(String.valueOf(nomor));
        holder.tvkepangkatan.setText(pangkatData.getGolonganpangkat());
        holder.tvnomorsk.setText(pangkatData.getNomorsk());
        holder.tvtgl.setText(pangkatData.getTerhitungtgl());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout ll_kepangkatan;
        private TextView tvkepangkatan, tvnomorsk, tvtgl, tvno;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_kepangkatan = itemView.findViewById(R.id.ll_pengabdian);
            tvkepangkatan = itemView.findViewById(R.id.tv_pangkat);
            tvnomorsk = itemView.findViewById(R.id.tv_nomorsk_pangkat);
            tvtgl = itemView.findViewById(R.id.tv_terhitungtgl_pangkat);
            tvno = itemView.findViewById(R.id.tv_no_kepangkatan);
        }
    }
}

