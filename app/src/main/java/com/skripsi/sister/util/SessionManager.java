package com.skripsi.sister.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.skripsi.sister.LoginActivity;
import com.skripsi.sister.models.ProfileData;

public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String KEY_ID = "id_profile";
    private static final String KEY_DOSEN = "dosen";
    private final String SHARE_NAME = "loginsession";
    private static final String is_login = "loginstatus";
    private final int MODE_PRIVATE = 0;
    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SharedPreferences getSp(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static String getKeyId(Context context) {
        return getSp(context).getString(KEY_ID, null);
    }

    public static void setKeyId(Context context, String id_profile) {
        getSp(context).edit().putString(KEY_ID, id_profile).apply();
    }

    public static ProfileData getDosen(Context context) {
        String dosen = getSp(context).getString(KEY_DOSEN, null);
        if (TextUtils.isEmpty(dosen)) return null;
        return new Gson().fromJson(dosen, ProfileData.class);
    }

    public static void setDosen(Context context, ProfileData profileData) {
        Gson gson = new Gson();
        String user = gson.toJson(profileData);
        getSp(context).edit().putString(KEY_DOSEN, user).apply();
    }

    public void storeLogin() {
        editor.putBoolean(is_login, true);
        editor.commit();
    }

    public Boolean Login() {
        return sharedPreferences.getBoolean(is_login, false);
    }

    public void checkLogin() {
        if (!this.Login()) {
            Intent i = new Intent(context, LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
    public void logout() {
        editor.clear();
        editor.commit();
    }
}
