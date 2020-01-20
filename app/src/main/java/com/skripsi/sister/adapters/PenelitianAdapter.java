package com.skripsi.sister.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.skripsi.sister.R;
import com.skripsi.sister.functions.Fungsiku;
import com.skripsi.sister.models.DeleteResponse;
import com.skripsi.sister.models.PenelitianData;
import com.skripsi.sister.net.Network;
import com.skripsi.sister.update.UpdatePenelitianActivity;
import com.skripsi.sister.util.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PenelitianAdapter extends RecyclerView.Adapter<PenelitianAdapter.ViewHolder> {
    private List <PenelitianData> data;
    private Context context;
    private PenelitianInterface penelitianInterface;

    public PenelitianAdapter(Context context) {
        this.context = context;
    }

    public List<PenelitianData> getData() {
        return data;
    }

    public void setData(List<PenelitianData> data) {
        this.data = data;
    }

    public void setPenelitianInterface(PenelitianInterface penelitianInterface) {
        this.penelitianInterface = penelitianInterface;
    }

    @NonNull
    @Override
    public PenelitianAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_penelitian, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PenelitianAdapter.ViewHolder holder, int position) {
        String idProfile = SessionManager.getKeyId(context);
        final PenelitianData penelitianData = getData().get(position);
        int nomor = position + 1;

        holder.tvno.setText(String.valueOf(nomor));
        holder.tvjudul.setText(penelitianData.getJudul());
        holder.tvskim.setText(penelitianData.getSkim());
        holder.tvthnpelaksanaan.setText(penelitianData.getThnpelaksanaan());
        holder.tvlamakegiatan.setText(penelitianData.getLamakegiatan());

        //setting onClick delete button
        holder.btnDelete.setOnClickListener(v -> {

            //pake dialog biasa
                new AlertDialog.Builder(context)
                        .setTitle("Perhatian !")
                        .setMessage("Apakah anda yakin ingin menghapus" + "\n" + penelitianData.getJudul() + " ?")
                        .setPositiveButton("Iya", (dialog, which) -> {
                            deleteData(idProfile, penelitianData.getId_penelitian());
                            dialog.dismiss();
                        })
                        .setNegativeButton("Tidak", (dialog, which) -> dialog.dismiss())
                        .show();
        });

        //setting onClick update button
        holder.btnEdit.setOnClickListener(v -> {
            Intent i = new Intent(context, UpdatePenelitianActivity.class);
            i.putExtra("data", penelitianData);
            context.startActivity(i);
            penelitianInterface.finishAct();
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout ll_penelitian, btnDelete, btnEdit;
        private TextView tvjudul, tvskim, tvthnpelaksanaan, tvno, tvlamakegiatan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvno = itemView.findViewById(R.id.tv_no_penelitian);
            ll_penelitian = itemView.findViewById(R.id.ll_penelitian);
            tvjudul = itemView.findViewById(R.id.tv_judul);
            tvskim = itemView.findViewById(R.id.tv_skim);
            tvthnpelaksanaan = itemView.findViewById(R.id.tv_thnpelaksanaan);
            tvlamakegiatan = itemView.findViewById(R.id.tv_lamakegiatan);
            btnDelete = itemView.findViewById(R.id.btn_delete_penelitian);
            btnEdit = itemView.findViewById(R.id.btn_edit_penelitian);
        }
    }

    private void deleteData(String idProfile, String idPenelitian) {
        Fungsiku.showProgress(context, "Menghapus data...");
        Network.provideApiService().deletePenelitian(idProfile, idPenelitian).enqueue(new Callback<DeleteResponse>() {
            @Override
            public void onResponse(Call<DeleteResponse> call, Response<DeleteResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {
                        Fungsiku.dissmissProgress();
                        penelitianInterface.callback("Data behasil dihapus");
                    } else {
                        Log.d("DeletePenelitian", "Error");
                        Fungsiku.dissmissProgress();
                        Toast.makeText(context, "Data gagal dihapus", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d("DeletePenelitian", "Error");
                    Fungsiku.dissmissProgress();
                    Toast.makeText(context, "Data gagal dihapus", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DeleteResponse> call, Throwable t) {
                Log.d("DeletePenelitian", t.getLocalizedMessage());
                Toast.makeText(context, "Data gagal dihapus", Toast.LENGTH_SHORT).show();
                Fungsiku.dissmissProgress();
            }
        });
    }

    public interface PenelitianInterface {
        void callback(String pesan);

        void finishAct();
    }
}

