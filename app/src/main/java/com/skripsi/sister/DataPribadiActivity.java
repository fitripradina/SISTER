package com.skripsi.sister;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.skripsi.sister.models.AlamatData;
import com.skripsi.sister.models.AlamatResponse;
import com.skripsi.sister.models.KeluargaData;
import com.skripsi.sister.models.KeluargaResponse;
import com.skripsi.sister.models.KepegawaianData;
import com.skripsi.sister.models.KepegawaianResponse;
import com.skripsi.sister.models.KependudukanData;
import com.skripsi.sister.models.KependudukanResponse;
import com.skripsi.sister.models.ProfileData;
import com.skripsi.sister.net.Network;
import com.skripsi.sister.util.SessionManager;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataPribadiActivity extends AppCompatActivity {
    private TextView tvNama, tvNidn, tvJenis, tvTanggal, tvTempat, tvIbu;
    private TextView tvNik, tvAgama, tvKewarganegaraan;
    private TextView tvStatusKawin, tvNamaSuamiIstri, tvNipSuamiistri, tvPekerjaan, tvTglSuami;
    private TextView tvEmail, tvAlamat, tvRt, tvRw, tvDusun, tvKelurahan, tvKota, tvProvinsi, tvKodepos, tvNotelpon, tvNohp;
    private TextView tvProgStudi, tvnip, tvStatusKepeg, tvStatusAktif, tvNoSkCPNS, tvTglSkCPNS, tvNoSkTMMD, tvTglMmmd, tvLembaga, tvPangkat, tvSumberGaji;
    private ImageView ivFoto;
    private String idProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pribadi);
//        ini untuk ambil id profile dari sm
        idProfile = SessionManager.getKeyId(this);
        onInit();
    }

    private void onInit() {

        initViewDataDiri();
        initDataProfile();

        initViewKependudukan();
        initDataKependudukan();

        initViewKeluarga();
        initDataKeluarga();

        initViewAlamat();
        initDataAlamat();

        initViewKepegawaian();
        initDataKepegawaian();

        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_profile);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initDataProfile() {
        ProfileData profileData = SessionManager.getDosen(this);
        if (profileData != null) {
            tvNama.setText(profileData.getNama());
            tvNidn.setText(profileData.getNidn());
            tvJenis.setText(profileData.getJenisKelamin());
            tvTanggal.setText(profileData.getTanggalLahir());
            tvTempat.setText(profileData.getTempatLahir());
            tvIbu.setText(profileData.getNamaIbuKandung());
            if (profileData.getFoto().length() >= 1) {
                Picasso.get().load(profileData.getFoto()).into(ivFoto);
            } else {
                Picasso.get().load(R.drawable.profile_default).into(ivFoto);
            }
        }

    }

    private void initViewDataDiri() {
        tvNama = findViewById(R.id.tvnama);
        tvNidn = findViewById(R.id.tvnidn);
        tvJenis = findViewById(R.id.tvjk);
        tvTanggal = findViewById(R.id.tvtgllahir);
        tvTempat = findViewById(R.id.tvtempatlahir);
        tvIbu = findViewById(R.id.tvnamaibu);
        ivFoto = findViewById(R.id.iv_foto_profil);
    }

//---------------------------------------//

    private void initViewKependudukan() {
        tvNik = findViewById(R.id.tvnik);
        tvAgama = findViewById(R.id.tvagama);
        tvKewarganegaraan = findViewById(R.id.tvkewarganegaraan);
    }

    private void initDataKependudukan() {
        Network.provideApiService().getKependudukan(idProfile).enqueue(new Callback<KependudukanResponse>() {
            @Override
            public void onResponse(Call<KependudukanResponse> call, Response<KependudukanResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        if (response.body().getData() != null) {
                            List<KependudukanData> data = response.body().getData();
                            tvNik.setText(data.get(0).getNik());
                            tvAgama.setText(data.get(0).getAgama());
                            tvKewarganegaraan.setText(data.get(0).getKegawarganegaraan());
                        } else {
                            Log.d("Data Kependudukan", "Error");
                        }
                    } else {
                        Log.d("Data Kependudukan", "Error");
                    }
                } else {
                    Log.d("Data Kependudukan", "Error");
                }
            }

            @Override
            public void onFailure(Call<KependudukanResponse> call, Throwable t) {
                Log.d("Data Kependudukan", t.getLocalizedMessage());
            }
        });

    }

//---------------------------------------//

    private void initViewKeluarga() {
        tvStatusKawin = findViewById(R.id.tvstatusperkawinan);
        tvNamaSuamiIstri = findViewById(R.id.tvnamasuamiistri);
        tvNipSuamiistri = findViewById(R.id.tvnipsuamiistri);
        tvPekerjaan = findViewById(R.id.tvpekerjaansuamiistri);
        tvTglSuami = findViewById(R.id.tvtglpns);
    }

    private void initDataKeluarga() {
        Network.provideApiService().getKeluarga(idProfile).enqueue(new Callback<KeluargaResponse>() {
            @Override
            public void onResponse(Call<KeluargaResponse> call, Response<KeluargaResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        if (response.body().getData() != null) {

                            // MASUKAN DATA KE VARIABLE LIST
                            List<KeluargaData> data = response.body().getData();
                            // MASUKAN DATA KE MASING MASING ITEM
                            tvStatusKawin.setText(data.get(0).getStatuskawin());
                            tvNamaSuamiIstri.setText(data.get(0).getNamasuamiistri());
                            tvNipSuamiistri.setText(data.get(0).getNipsuamiistri());
                            tvPekerjaan.setText(data.get(0).getPekerjaansuamiistri());
                            tvTglSuami.setText(data.get(0).getTglpnssuamiistri());
                        } else {
                            Log.d("Data Keluarga", "Error");
                        }
                    } else {
                        Log.d("Data Keluarga", "Error");
                    }
                } else {
                    Log.d("Data Keluarga", "Error");
                }
            }

            @Override
            public void onFailure(Call<KeluargaResponse> call, Throwable t) {
                Log.d("Data Keluarga", t.getLocalizedMessage());
            }
        });

    }

//---------------------------------------//

    private void initViewAlamat() {
        tvEmail = findViewById(R.id.tvemail);
        tvAlamat = findViewById(R.id.tvalamat);
        tvRt = findViewById(R.id.tvrt);
        tvRw = findViewById(R.id.tvrw);
        tvDusun = findViewById(R.id.tvdusun);
        tvKelurahan = findViewById(R.id.tvkelurahan);
        tvKota = findViewById(R.id.tvkota);
        tvProvinsi = findViewById(R.id.tvprovinsi);
        tvKodepos = findViewById(R.id.tvkodepos);
        tvNotelpon = findViewById(R.id.tvtelepon);
        tvNohp = findViewById(R.id.tvnohp);
    }

    private void initDataAlamat() {
        Network.provideApiService().getAlamat(idProfile).enqueue(new Callback<AlamatResponse>() {
            @Override
            public void onResponse(Call<AlamatResponse> call, Response<AlamatResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        if (response.body().getData() != null) {

                            // MASUKAN DATA KE VARIABLE LIST
                            List<AlamatData> data = response.body().getData();
                            // MASUKAN DATA KE MASING MASING ITEM
                            tvEmail.setText(data.get(0).getEmail());
                            tvAlamat.setText(data.get(0).getAlamat());
                            tvRt.setText(data.get(0).getRt());
                            tvRw.setText(data.get(0).getRw());
                            tvDusun.setText(data.get(0).getDusun());
                            tvKelurahan.setText(data.get(0).getKelurahan());
                            tvKota.setText(data.get(0).getKotaKabupaten());
                            tvProvinsi.setText(data.get(0).getProvinsi());
                            tvKodepos.setText(data.get(0).getKodepos());
                            tvNotelpon.setText(data.get(0).getNoTelpon());
                            tvNohp.setText(data.get(0).getNoHp());
                        } else {
                            Log.d("Data Alamat", "Error");
                        }
                    } else {
                        Log.d("Data Alamat", "Error");
                    }
                } else {
                    Log.d("Data Alamat", "Error");
                }
            }

            @Override
            public void onFailure(Call<AlamatResponse> call, Throwable t) {
                Log.d("Data Alamat", t.getLocalizedMessage());
            }
        });

    }


    //---------------------------------------//

    private void initViewKepegawaian() {
        tvProgStudi = findViewById(R.id.tvprogstudi);
        tvnip = findViewById(R.id.tvnip);
        tvStatusKepeg = findViewById(R.id.tvstatuskepegawaian);
        tvStatusAktif = findViewById(R.id.tvstatuskeaktifan);
        tvNoSkCPNS = findViewById(R.id.tvnoskcpns);
        tvTglSkCPNS = findViewById(R.id.tvtglmulaiCPNS);
        tvNoSkTMMD = findViewById(R.id.tvnosktmmd);
        tvTglMmmd = findViewById(R.id.tvtmmd);
        tvLembaga = findViewById(R.id.tvlembaga);
        tvPangkat = findViewById(R.id.tvpangkatgolongan);
        tvSumberGaji = findViewById(R.id.tvsumbergaji);

    }

    private void initDataKepegawaian() {
        Network.provideApiService().getKepegawaian(idProfile).enqueue(new Callback<KepegawaianResponse>() {
            @Override
            public void onResponse(Call<KepegawaianResponse> call, Response<KepegawaianResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        if (response.body().getData() != null) {
                            // MASUKAN DATA KE VARIABLE LIST
                            List<KepegawaianData> data = response.body().getData();
                            // MASUKAN DATA KE MASING MASING ITEM
                            tvProgStudi.setText(data.get(0).getProgStudi());
                            tvnip.setText(data.get(0).getNip());
                            tvStatusKepeg.setText(data.get(0).getStatusKepegawaian());
                            tvStatusAktif.setText(data.get(0).getStatusKeaktifan());
                            tvNoSkCPNS.setText(data.get(0).getNoskCpns());
                            tvTglSkCPNS.setText(data.get(0).getTglSkcpns());
                            tvNoSkTMMD.setText(data.get(0).getNoskTmmd());
                            tvTglMmmd.setText(data.get(0).getTglTmmd());
                            tvLembaga.setText(data.get(0).getLembagaPengangkat());
                            tvPangkat.setText(data.get(0).getPangkatGol());
                            tvSumberGaji.setText(data.get(0).getSumberGaji());
                        } else {
                            Log.d("Data Kepegawaian", "Error");
                        }
                    } else {
                        Log.d("Data Kepegawaian", "Error");
                    }
                } else {
                    Log.d("Data Kepegawaian", "Error");
                }
            }

            @Override
            public void onFailure(Call<KepegawaianResponse> call, Throwable t) {
                Log.d("Data Kepegawaian", t.getLocalizedMessage());

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
