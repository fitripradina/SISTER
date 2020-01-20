package com.skripsi.sister;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skripsi.sister.adapters.PengabdianAdapter;
import com.skripsi.sister.models.PengabdianData;
import com.skripsi.sister.models.PengabdianResponse;
import com.skripsi.sister.net.Network;
import com.skripsi.sister.util.SessionManager;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PengabdianActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PengabdianAdapter pengabdianAdapter;
    private String idProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengabdian);
        onInit();
    }

    private void onInit() {
        idProfile = SessionManager.getKeyId(this);
        initToolbar();
        initRecyclerView();
        initAdapter();
        setRecyclerView();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_pengabdian);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.rv_pengabdian);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initAdapter() {
        pengabdianAdapter = new PengabdianAdapter(this);
    }

    private void setRecyclerView() {
        Network.provideApiService().getPengabdian(idProfile).enqueue(new Callback<PengabdianResponse>() {
            @Override
            public void onResponse(Call<PengabdianResponse> call, Response<PengabdianResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        List<PengabdianData> data = response.body().getData();

                        //isi recyclerView dengan data dari api
                        pengabdianAdapter.setData(data);
                        recyclerView.setAdapter(pengabdianAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<PengabdianResponse> call, Throwable t) {
                Log.d("Pengabdian", t.getLocalizedMessage());

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
