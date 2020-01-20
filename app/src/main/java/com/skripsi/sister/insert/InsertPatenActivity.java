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
import com.skripsi.sister.PatenActivity;
import com.skripsi.sister.R;
import com.skripsi.sister.functions.Fungsiku;
import com.skripsi.sister.models.InsertResponse;
import com.skripsi.sister.net.Network;
import com.skripsi.sister.util.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertPatenActivity extends AppCompatActivity {
    private String idProfile;
    private TextInputLayout tiljudul, tiljenis, tiltglterbit;
    private TextInputEditText etjudul, etjenis, ettglterbit;
    private Button btnbatal, btnsimpan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_paten);
        onInit();
    }

    private void onInit() {
        idProfile = SessionManager.getKeyId(this);
        initToolbar();
        initView();
        validasi();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbarInsertPaten);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initView() {
        tiljudul = findViewById(R.id.til_judulpaten);
        tiljenis = findViewById(R.id.til_jenis);
        tiltglterbit = findViewById(R.id.til_tgl_terbit);
        etjudul = findViewById(R.id.et_judulpaten);
        etjenis = findViewById(R.id.et_jenispaten);
        ettglterbit = findViewById(R.id.et_tgl_terbit);
        btnbatal = findViewById(R.id.btn_batal_paten);
        btnsimpan = findViewById(R.id.btn_simpan_paten);

        btnbatal.setOnClickListener(v -> {
            startActivity(new Intent(InsertPatenActivity.this, PatenActivity.class));
            InsertPatenActivity.this.finish();
        });

    }

    private void validasi () {
        btnsimpan.setOnClickListener(v -> {
            if (etjudul.getText().length() <= 0) {
                setError(tiljudul);
            } else if (etjenis.getText().length() <= 0) {
                setError(tiljenis);
            } else if (ettglterbit.getText().length() <= 0) {
                setError(tiltglterbit);
            } else {
                kirimData();
            }
        });

    }

    private void kirimData () {
        Fungsiku.showProgress(this, "Mengirim Data...");
        String judul  = etjudul.getText().toString();
        String jenis  = etjenis.getText().toString();
        String tglterbit  = ettglterbit.getText().toString();
        Network.provideApiService().insertPaten(idProfile, judul, jenis, tglterbit).enqueue(new Callback<InsertResponse>() {
            @Override
            public void onResponse(Call<InsertResponse> call, Response<InsertResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        Fungsiku.dissmissProgress();
                        Toast.makeText(InsertPatenActivity.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(InsertPatenActivity.this, PatenActivity.class));
                        InsertPatenActivity.this.finish();
                    } else {
                        Fungsiku.dissmissProgress();
                        Log.d("InsertPaten", "Error");
                        Toast.makeText(InsertPatenActivity.this, "Data gagal kirim", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Fungsiku.dissmissProgress();
                    Log.d("Insert Paten", "Error");
                    Toast.makeText(InsertPatenActivity.this, "Data gagal kirim", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<InsertResponse> call, Throwable t) {
                Fungsiku.dissmissProgress();
                Log.d("Insert Paten", t.getLocalizedMessage());
                Toast.makeText(InsertPatenActivity.this, "Data gagal kirim", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setError(TextInputLayout textInputLayout) {
        textInputLayout.setError("Kolom tidak boleh kosong !");
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(InsertPatenActivity.this, PatenActivity.class));
        InsertPatenActivity.this.finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        startActivity(new Intent(InsertPatenActivity.this, PatenActivity.class));
        InsertPatenActivity.this.finish();
        return super.onSupportNavigateUp();
    }



}
