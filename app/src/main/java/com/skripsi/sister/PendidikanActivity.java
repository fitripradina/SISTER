package com.skripsi.sister;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skripsi.sister.adapters.PendidikanAdapter;
import com.skripsi.sister.models.PendidikanData;
import com.skripsi.sister.models.PendidikanResponse;
import com.skripsi.sister.net.Network;
import com.skripsi.sister.util.SessionManager;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendidikanActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PendidikanAdapter pendidikanAdapter;
    private String idProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendidikan);
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
        Toolbar toolbar = findViewById(R.id.toolbar_pendidikan);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.rv_pendidikan);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initAdapter() {
        pendidikanAdapter = new PendidikanAdapter(this);
    }


    private void setRecyclerView() {
        Network.provideApiService().getPendidikan(idProfile).enqueue(new Callback<PendidikanResponse>() {
            @Override
            public void onResponse(Call<PendidikanResponse> call, Response<PendidikanResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        List<PendidikanData> data = response.body().getData();

                        //isi recyclerView dengan data dari api
                        pendidikanAdapter.setData(data);
                        recyclerView.setAdapter(pendidikanAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<PendidikanResponse> call, Throwable t) {
                Log.d("Pendidikan", t.getLocalizedMessage());

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
