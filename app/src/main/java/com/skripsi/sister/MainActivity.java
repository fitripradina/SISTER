package com.skripsi.sister;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.skripsi.sister.models.ProfileData;
import com.skripsi.sister.util.SessionManager;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private CardView btnjabatan, btnpangkat,btnpendidikan, btnpengajaran, btnpenelitian,
            btnpublikasi,btnpaten, btnpengabdian ;
    private ImageView btnsetting;
    private LinearLayout llprofiemain;
    private TextView tvnamauser, tvnipuser;
    private CircleImageView ivfotomain;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llprofiemain = findViewById(R.id.ll_profile);
        tvnamauser = findViewById(R.id.tv_nama_main);
        tvnipuser = findViewById(R.id.tv_nip_main);
        ivfotomain = findViewById(R.id.iv_foto_main);
        btnjabatan = findViewById(R.id.btnjabatan);
        btnpangkat = findViewById(R.id.btnpangkat);
        btnpendidikan = findViewById(R.id.btnpendidikan);
        btnpengajaran = findViewById(R.id.btnpengajaran);
        btnpenelitian = findViewById(R.id.btnpenelitian);
        btnpublikasi = findViewById(R.id.btnpublikasi);
        btnpaten = findViewById(R.id.btnpaten);
        btnpengabdian = findViewById(R.id.btnpengabdian);
        btnsetting = findViewById(R.id.btn_setting);

        llprofiemain.setOnClickListener(this);
        btnjabatan.setOnClickListener(this);
        btnpangkat.setOnClickListener(this);
        btnpendidikan.setOnClickListener(this);
        btnpengajaran.setOnClickListener(this);
        btnpenelitian.setOnClickListener(this);
        btnpublikasi.setOnClickListener(this);
        btnpaten.setOnClickListener(this);
        btnpengabdian.setOnClickListener(this);
        btnsetting.setOnClickListener(this);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        setprofile();

    }

    @Override
    public void onClick(View v) {
        if (v == llprofiemain){
            startActivity(new Intent(MainActivity.this, DataPribadiActivity.class));
        }
        if (v == btnjabatan){
            startActivity(new Intent(MainActivity.this, JabatanActivity.class));
        }
        if (v == btnpangkat){
            startActivity(new Intent(MainActivity.this, PangkatActivity.class));
        }
        if (v == btnpendidikan){
            startActivity(new Intent(MainActivity.this, PendidikanActivity.class));
        }
        if (v == btnpengajaran){
            startActivity(new Intent(MainActivity.this, PengajaranActivity.class));
        }
        if (v == btnpenelitian){
            startActivity(new Intent(MainActivity.this, PenelitianActivity.class));
        }
        if (v == btnpublikasi){
            startActivity(new Intent(MainActivity.this, PublikasiActivity.class));
        }
        if (v == btnpaten){
            startActivity(new Intent(MainActivity.this, PatenActivity.class));
        }
        if (v == btnpengabdian){
            startActivity(new Intent(MainActivity.this, PengabdianActivity.class));
        }
        if (v == btnsetting) {
            startActivity(new Intent(MainActivity.this, SettingActivity.class));
            finish();
        }
    }

    private void setprofile() {
        ProfileData data = SessionManager.getDosen(this);

        if (data != null) {
            tvnamauser.setText(data.getNama());
            tvnipuser.setText(data.getNidn());
            if (data.getFoto().length() >= 1) {
                Picasso.get().load(data.getFoto()).into(ivfotomain);
            } else {
                Picasso.get().load(R.drawable.profile_default).into(ivfotomain);
            }
        } else {
            Log.d("Set Profile", "Anda Belum Login");
        }
    }

    @Override
    public void onBackPressed() {
    }
}

