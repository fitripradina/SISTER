package com.skripsi.sister.insert;

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
import com.skripsi.sister.models.InsertResponse;
import com.skripsi.sister.net.Network;
import com.skripsi.sister.util.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertPenelitianActivity extends AppCompatActivity {
    private String idProfile;
    private TextInputLayout tilJudul, tilSkim, tilTahun, tilLama;
    private TextInputEditText etJudul, etSkim, etTahun, etLama;
    private Button btnBatal, btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_penelitian);
        onInit();
    }

    private void onInit() {
        idProfile = SessionManager.getKeyId(this);
        initToolbar();
        initView();
        validasi();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbarInsertPenelitian);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initView() {
        tilJudul = findViewById(R.id.til_judul_penelitian);
        tilSkim = findViewById(R.id.til_skim_penelitian);
        tilTahun = findViewById(R.id.til_tahun_penelitian);
        tilLama = findViewById(R.id.til_lama_penelitian);
        etJudul = findViewById(R.id.et_judul_penelitian);
        etSkim = findViewById(R.id.et_skim_penelitian);
        etTahun = findViewById(R.id.et_tahun_penelitian);
        etLama = findViewById(R.id.et_lama_penelitian);
        btnBatal = findViewById(R.id.btn_batal_penelitian);
        btnSimpan = findViewById(R.id.btn_simpan_penelitian);

        btnBatal.setOnClickListener(v -> {
            startActivity(new Intent(InsertPenelitianActivity.this, PenelitianActivity.class));
            InsertPenelitianActivity.this.finish();
        });
    }

    private void validasi() {
        btnSimpan.setOnClickListener(v -> {
            if (etJudul.getText().length() <= 0) {
                setError(tilJudul);
            } else if (etSkim.getText().length() <= 0) {
                setError(tilSkim);
            } else if (etTahun.getText().length() <= 0) {
                setError(tilTahun);
            } else if (etLama.getText().length() <= 0) {
                setError(tilLama);
            } else {
                kirimData();
            }
        });
    }

    private void kirimData() {
        Fungsiku.showProgress(this, "Mengirim data...");
        String judul = etJudul.getText().toString();
        String skim = etSkim.getText().toString();
        String tahun = etTahun.getText().toString();
        String lama = etLama.getText().toString();
        Network.provideApiService().insertPenelitian(idProfile, judul, skim, tahun, lama).enqueue(new Callback<InsertResponse>() {
            @Override
            public void onResponse(Call<InsertResponse> call, Response<InsertResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        Fungsiku.dissmissProgress();
                        Toast.makeText(InsertPenelitianActivity.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(InsertPenelitianActivity.this, PenelitianActivity.class));
                        InsertPenelitianActivity.this.finish();
                    } else {
                        Fungsiku.dissmissProgress();
                        Log.d("InsertPenelitian", "Error");
                        Toast.makeText(InsertPenelitianActivity.this, "Data gagal kirim", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Fungsiku.dissmissProgress();
                    Log.d("InsertPenelitian", "Error");
                    Toast.makeText(InsertPenelitianActivity.this, "Data gagal kirim", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<InsertResponse> call, Throwable t) {
                Fungsiku.dissmissProgress();
                Log.d("InsertPenelitian", t.getLocalizedMessage());
                Toast.makeText(InsertPenelitianActivity.this, "Data gagal kirim", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setError(TextInputLayout textInputLayout) {
        textInputLayout.setError("Kolom tidak boleh kosong !");
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(InsertPenelitianActivity.this, PenelitianActivity.class));
        InsertPenelitianActivity.this.finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        startActivity(new Intent(InsertPenelitianActivity.this, PenelitianActivity.class));
        InsertPenelitianActivity.this.finish();
        return super.onSupportNavigateUp();
    }
}
