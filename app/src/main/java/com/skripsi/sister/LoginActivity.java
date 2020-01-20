package com.skripsi.sister;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.skripsi.sister.functions.Fungsiku;
import com.skripsi.sister.models.ProfileData;
import com.skripsi.sister.models.ProfileResponse;
import com.skripsi.sister.net.Network;
import com.skripsi.sister.util.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private TextInputEditText password, email;
    private TextInputLayout tilpassword, tilemail;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);

        login = findViewById(R.id.btn_masok);
        password =findViewById(R.id.tv_pw);
        email = findViewById(R.id.tv_email_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.length() == 0) {
                    errText(tilemail);
                } else if (password.length() == 0) {
                    errText(tilpassword);
                } else {
                    String user = email.getText().toString();
                    String pw = password.getText().toString();
                    Fungsiku.showProgress(LoginActivity.this, "Memuat...");

                    Network.provideApiService().postLogin(user,pw).enqueue(new Callback<ProfileResponse>() {
                        @Override
                        public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                            if (response != null && response.isSuccessful()) {
                                if (response.body().getStatus() == true) {
                                    List<ProfileData> dosen = response.body().getData();
                                    sessionManager.storeLogin();
                                    SessionManager.setKeyId(LoginActivity.this, dosen.get(0).getIdProfile());
                                    SessionManager.setDosen(LoginActivity.this, dosen.get(0));
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    Fungsiku.dissmissProgress();
                                } else {
                                    Fungsiku.dissmissProgress();
                                    toast("Usernme atau Password Salah");
                                }
                            } else {
                                Fungsiku.dissmissProgress();
                                toast(response.errorBody().toString());
                            }
                        }

                        @Override
                        public void onFailure(Call<ProfileResponse> call, Throwable t) {
                            Log.d("Failed", "onFailure: " + t.getLocalizedMessage());
                            toast("Gagal Terhubung, Periksa Kembali Koneksi Anda");
                            Fungsiku.dissmissProgress();

                        }
                    });
                }
            }
        });

    }

    private void errText(TextInputLayout editText) {
        editText.setError("Tidak Boleh Kosong!");
    }
    private void toast(String  str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
    }
}

