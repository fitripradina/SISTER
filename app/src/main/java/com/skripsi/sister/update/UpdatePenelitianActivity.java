package com.skripsi.sister.update;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.skripsi.sister.PenelitianActivity;
import com.skripsi.sister.R;
import com.skripsi.sister.functions.Fungsiku;
import com.skripsi.sister.models.PenelitianData;
import com.skripsi.sister.models.UpdateResponse;
import com.skripsi.sister.net.Network;
import com.skripsi.sister.util.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdatePenelitianActivity extends AppCompatActivity {

    private String idProfile;
    private TextInputLayout tilJudul, tilSkim, tilTahun, tilLama;
    private TextInputEditText etJudul, etSkim, etTahun, etLama;
    private Button btnBatal, btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_penelitian);
        onInit();
    }

    private void onInit() {
        idProfile = SessionManager.getKeyId(this);
        initToolbar();
        initView();
        setUpdate();

    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbarUpdatePenelitian);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initView() {
        tilJudul = findViewById(R.id.til_judul_update_penelitian);
        tilSkim = findViewById(R.id.til_skim_update_penelitian);
        tilTahun = findViewById(R.id.til_tahun_update_penelitian);
        tilLama = findViewById(R.id.til_lama_update_penelitian);
        etJudul = findViewById(R.id.et_judul_update_penelitian);
        etSkim = findViewById(R.id.et_skim_update_penelitian);
        etTahun = findViewById(R.id.et_tahun_update_penelitian);
        etLama = findViewById(R.id.et_lama_update_penelitian);
        btnBatal = findViewById(R.id.btn_batal_update_penelitian);
        btnSimpan = findViewById(R.id.btn_simpan_update_penelitian);

        btnBatal.setOnClickListener(v -> {
            startActivity(new Intent(UpdatePenelitianActivity.this, PenelitianActivity.class));
            UpdatePenelitianActivity.this.finish();
        });
    }

    private void setUpdate() {
        PenelitianData penelitianData = getIntent().getParcelableExtra("data");

        etJudul.setText(penelitianData.getJudul());
        etSkim.setText(penelitianData.getSkim());
        etTahun.setText(penelitianData.getThnpelaksanaan());
        etLama.setText(penelitianData.getLamakegiatan());

        btnSimpan.setOnClickListener(v ->{
            if (etJudul.getText().length() <= 0) {
                setError(tilJudul);
            } else if (etSkim.getText().length() <= 0) {
                setError(tilSkim);
            } else if (etTahun.getText().length() <= 0) {
                setError(tilTahun);
            } else if (etLama.getText().length() <= 0) {
                setError(tilLama);
            } else {
                String id, judul, skim, tahun, lama;
                id = penelitianData.getId_penelitian();
                judul = etJudul.getText().toString();
                skim = etSkim.getText().toString();
                tahun = etTahun.getText().toString();
                lama = etLama.getText().toString();

                Fungsiku.showProgress(this, "Menyimpan data...");
                Network.provideApiService().updatePenelitian(idProfile, id, judul, skim, tahun, lama).enqueue(new Callback<UpdateResponse>() {
                    @Override
                    public void onResponse(Call<UpdateResponse> call, Response<UpdateResponse> response) {
                        if (response.isSuccessful()) {
                            if (response.body().isStatus()) {
                                Fungsiku.dissmissProgress();

                                //pake dialog biasa
                                AlertDialog.Builder dialog = new AlertDialog.Builder(UpdatePenelitianActivity.this)
                                        .setTitle("Berhasil !")
                                        .setMessage("Data berhasil dirubah")
                                        .setPositiveButton("Ok", (dialog1, which) -> {
                                            dialog1.dismiss();
                                            startActivity(new Intent(UpdatePenelitianActivity.this, PenelitianActivity.class));
                                            UpdatePenelitianActivity.this.finish();
                                        });
                                dialog.setCancelable(false);
                                dialog.show();


                            } else {
                                Log.d("UpdatePenelitian", "Error");
                                Fungsiku.dissmissProgress();
                                Toast.makeText(UpdatePenelitianActivity.this, "Data gagal diubah !", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.d("UpdatePenelitian", "Error");
                            Fungsiku.dissmissProgress();
                            Toast.makeText(UpdatePenelitianActivity.this, "Data gagal diubah !", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UpdateResponse> call, Throwable t) {
                        Log.d("UpdatePenelitian", t.getLocalizedMessage());
                        Fungsiku.dissmissProgress();
                        Toast.makeText(UpdatePenelitianActivity.this, "Data gagal diubah !", Toast.LENGTH_SHORT).show();

                    }
                });
            }

        });
    }

    private void setError(TextInputLayout textInputLayout) {
        textInputLayout.setError("Kolom tidak boleh kosong !");
    }
}
