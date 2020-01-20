package com.skripsi.sister.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublikasiData {
        @SerializedName("judul")
        @Expose
        private String judul;
        @SerializedName("jenis_publikasi")
        @Expose
        private String jenispublikasi;
        @SerializedName("tgl_terbit")
        @Expose
        private String tglterbit;
        @SerializedName("asal_data")
        @Expose
        private String asaldata;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJenispublikasi() {
        return jenispublikasi;
    }

    public void setJenispublikasi(String jenispublikasi) {
        this.jenispublikasi = jenispublikasi;
    }

    public String getTglterbit() {
        return tglterbit;
    }

    public void setTglterbit(String tglterbit) {
        this.tglterbit = tglterbit;
    }

    public String getAsaldata() {
        return asaldata;
    }

    public void setAsaldata(String asaldata) {
        this.asaldata = asaldata;
    }
}
