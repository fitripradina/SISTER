package com.skripsi.sister;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skripsi.sister.adapters.PangkatAdapter;
import com.skripsi.sister.models.PangkatData;
import com.skripsi.sister.models.PangkatResponse;
import com.skripsi.sister.net.Network;
import com.skripsi.sister.util.SessionManager;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PangkatActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PangkatAdapter pangkatAdapter;
    private String idProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pangkat);
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
        Toolbar toolbar = findViewById(R.id.toolbar_pangkat);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.rv_pangkat);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initAdapter() {
        pangkatAdapter = new PangkatAdapter(this);
    }


    private void setRecyclerView() {
        Network.provideApiService().getPangkat(idProfile).enqueue(new Callback<PangkatResponse>() {
            @Override
            public void onResponse(Call<PangkatResponse> call, Response<PangkatResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        List<PangkatData> data = response.body().getData();

                        //isi recyclerView dengan data dari api
                        pangkatAdapter.setData(data);
                        recyclerView.setAdapter(pangkatAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<PangkatResponse> call, Throwable t) {
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
