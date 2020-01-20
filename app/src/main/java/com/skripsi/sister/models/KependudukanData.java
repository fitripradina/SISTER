package com.skripsi.sister.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KependudukanData {
    @SerializedName("nik")
    @Expose
    private String nik;
    @SerializedName("agama")
    @Expose
    private String agama;
    @SerializedName("kewarganegaraan")
    @Expose
    private String kegawarganegaraan;

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getKegawarganegaraan() {
        return kegawarganegaraan;
    }

    public void setKegawarganegaraan(String kegawarganegaraan) {
        this.kegawarganegaraan = kegawarganegaraan;
    }
}
