package com.skripsi.sister;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skripsi.sister.adapters.JabatanAdapter;
import com.skripsi.sister.models.JabatanData;
import com.skripsi.sister.models.JabatanResponse;
import com.skripsi.sister.net.Network;
import com.skripsi.sister.util.SessionManager;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JabatanActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private JabatanAdapter jabatanAdapter;
    private String idProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jabatan);
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
        Toolbar toolbar = findViewById(R.id.toolbar_jabatan);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.rv_jabatan);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initAdapter() {
        jabatanAdapter = new JabatanAdapter(this);
    }


    private void setRecyclerView() {
        Network.provideApiService().getJabatan(idProfile).enqueue(new Callback<JabatanResponse>() {
            @Override
            public void onResponse(Call<JabatanResponse> call, Response<JabatanResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        List<JabatanData> data = response.body().getData();

                        //isi recyclerView dengan data dari api
                        jabatanAdapter.setData(data);
                        recyclerView.setAdapter(jabatanAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<JabatanResponse> call, Throwable t) {
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
