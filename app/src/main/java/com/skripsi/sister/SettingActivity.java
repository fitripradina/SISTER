package com.skripsi.sister;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.skripsi.sister.util.SessionManager;

public class SettingActivity extends AppCompatActivity {
    private Button btnlogout;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        sessionManager = new SessionManager(this);

        btnlogout = findViewById(R.id.btn_logout);
        btnlogout.setOnClickListener(v -> {
            sessionManager.logout();
            sessionManager.checkLogin();
            finish();
        });
        initToolbar();
    }
    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_setting);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        startActivity(new Intent(SettingActivity.this, MainActivity.class));
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SettingActivity.this, MainActivity.class));
        finish();
    }
}
