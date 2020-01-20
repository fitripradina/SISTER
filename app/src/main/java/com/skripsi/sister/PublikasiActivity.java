package com.skripsi.sister;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skripsi.sister.adapters.PublikasiAdapter;
import com.skripsi.sister.models.PublikasiData;
import com.skripsi.sister.models.PublikasiResponse;
import com.skripsi.sister.net.Network;
import com.skripsi.sister.util.SessionManager;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PublikasiActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PublikasiAdapter publikasiAdapter;
    private String idProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publikasi);
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
        Toolbar toolbar = findViewById(R.id.toolbar_publikasi);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.rv_publikasi);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initAdapter() {
        publikasiAdapter = new PublikasiAdapter(this);
    }


    private void setRecyclerView() {
        Network.provideApiService().getPublikasi(idProfile).enqueue(new Callback<PublikasiResponse>() {
            @Override
            public void onResponse(Call<PublikasiResponse> call, Response<PublikasiResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        List<PublikasiData> data = response.body().getData();

                        //isi recyclerView dengan data dari api
                        publikasiAdapter.setData(data);
                        recyclerView.setAdapter(publikasiAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<PublikasiResponse> call, Throwable t) {
                Log.d("Publikasi", t.getLocalizedMessage());

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
