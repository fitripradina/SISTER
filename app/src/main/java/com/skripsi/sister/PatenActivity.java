package com.skripsi.sister;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.skripsi.sister.adapters.PatenAdapter;
import com.skripsi.sister.insert.InsertPatenActivity;
import com.skripsi.sister.models.PatenData;
import com.skripsi.sister.models.PatenResponse;
import com.skripsi.sister.net.Network;
import com.skripsi.sister.util.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatenActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PatenAdapter patenAdapter;
    private String idProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paten);
        onInit();
    }

    private void onInit() {
        idProfile = SessionManager.getKeyId(this);
        initToolbar();
        initRecyclerView();
        initAdapter();
        setRecyclerView();
        setupTombolTambah();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_paten);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.rv_paten);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initAdapter() {
        {
            patenAdapter = new PatenAdapter(this);
        }
    }


    private void setRecyclerView() {
        Network.provideApiService().getPaten(idProfile).enqueue(new Callback<PatenResponse>() {
            @Override
            public void onResponse(Call<PatenResponse> call, Response<PatenResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        List<PatenData> data = response.body().getData();

                        //isi recyclerView dengan data dari api
                        patenAdapter.setData(data);
                        recyclerView.setAdapter(patenAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<PatenResponse> call, Throwable t) {
                Log.d("Paten", t.getLocalizedMessage());

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void setupTombolTambah() {
        FloatingActionButton floatingActionButton = findViewById(R.id.btn_tambah_paten);
        floatingActionButton.setOnClickListener(v -> {
            startActivity(new Intent(this, InsertPatenActivity.class));
            finish();
        });

    }
}
