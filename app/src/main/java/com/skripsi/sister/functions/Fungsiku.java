package com.skripsi.sister.functions;

import android.app.ProgressDialog;
import android.content.Context;

public class Fungsiku {

    private static ProgressDialog progressDialog;

    // FUNGSIKU INI GUNANYA UNTUK : menampilkan dialog
    public static void showProgress(Context context, String pesan) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(pesan);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    //NAH YANG INI UNTUK ILANGIN DIALOGNYA
    public static void dissmissProgress() {
        progressDialog.dismiss();
    }
}
