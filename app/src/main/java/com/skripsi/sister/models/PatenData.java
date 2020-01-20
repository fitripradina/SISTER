package com.skripsi.sister.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatenData {
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("jenis")
    @Expose
    private String jenis;
    @SerializedName("tgl_terbit")
    @Expose
    private String tglterbit;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getTglterbit() {
        return tglterbit;
    }

    public void setTglterbit(String tglterbit) {
        this.tglterbit = tglterbit;
    }
}
