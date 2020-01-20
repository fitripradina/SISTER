package com.skripsi.sister;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.skripsi.sister.adapters.PenelitianAdapter;
import com.skripsi.sister.insert.InsertPenelitianActivity;
import com.skripsi.sister.models.PenelitianData;
import com.skripsi.sister.models.PenelitianResponse;
import com.skripsi.sister.net.Network;
import com.skripsi.sister.util.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PenelitianActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PenelitianAdapter penelitianAdapter;
    private String idProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penelitian);
        onInit();
    }

    private void onInit() {
        idProfile = SessionManager.getKeyId(this);
        initToolbar();
        initRecyclerView();
        initAdapter();
        setRecyclerView();
        setupTombolTambah();
        callbackResponse();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_penelitian);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.rv_penelitian);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initAdapter() {
        penelitianAdapter = new PenelitianAdapter(this);
    }


    private void setRecyclerView() {
        Network.provideApiService().getPenelitian(idProfile).enqueue(new Callback<PenelitianResponse>() {
            @Override
            public void onResponse(Call<PenelitianResponse> call, Response<PenelitianResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        List<PenelitianData> data = response.body().getData();

                        //isi recyclerView dengan data dari api
                        penelitianAdapter.setData(data);
                        recyclerView.setAdapter(penelitianAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<PenelitianResponse> call, Throwable t) {
                Log.d("Penelitian", t.getLocalizedMessage());

            }
        });
    }

    private void callbackResponse() {
        penelitianAdapter.setPenelitianInterface(new PenelitianAdapter.PenelitianInterface() {
            @Override
            public void callback(String pesan) {
                setRecyclerView();
                Toast.makeText(PenelitianActivity.this, pesan, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void finishAct() {
                PenelitianActivity.this.finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void setupTombolTambah() {
        FloatingActionButton floatingActionButton = findViewById(R.id.btn_tambah_penelitian);
        floatingActionButton.setOnClickListener(v -> {
            startActivity(new Intent(this, InsertPenelitianActivity.class));
            finish();
        });

    }
}
