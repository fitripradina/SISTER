package com.skripsi.sister;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skripsi.sister.adapters.PengajaranAdapter;
import com.skripsi.sister.models.PengajaranData;
import com.skripsi.sister.models.PengajaranResponse;
import com.skripsi.sister.net.Network;
import com.skripsi.sister.util.SessionManager;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PengajaranActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PengajaranAdapter pengajaranAdapter;
    private String idProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengajaran);
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
        Toolbar toolbar = findViewById(R.id.toolbar_pengajaran);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.rv_pengajaran);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initAdapter() {
        pengajaranAdapter = new PengajaranAdapter(this);
    }


    private void setRecyclerView() {
        Network.provideApiService().getPengajaran(idProfile).enqueue(new Callback<PengajaranResponse>() {
            @Override
            public void onResponse(Call<PengajaranResponse> call, Response<PengajaranResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        List<PengajaranData> data = response.body().getData();

                        //isi recyclerView dengan data dari api
                        pengajaranAdapter.setData(data);
                        recyclerView.setAdapter(pengajaranAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<PengajaranResponse> call, Throwable t) {
                Log.d("Pengajaran", t.getLocalizedMessage());

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
