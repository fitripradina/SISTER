package com.skripsi.sister.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PengajaranData {
        @SerializedName("mata_kuliah")
        @Expose
        private String matakuliah;
        @SerializedName("kelas")
        @Expose
        private String kelas;
        @SerializedName("jumlah_mhs")
        @Expose
        private String jumlahmhs;
        @SerializedName("sks")
        @Expose
        private String sks;
    private List<PengajaranData> data = null;

    public String getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(String matakuliah) {
        this.matakuliah = matakuliah;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getJumlahmhs() {
        return jumlahmhs;
    }

    public void setJumlahmhs(String jumlahmhs) {
        this.jumlahmhs = jumlahmhs;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }

    public List<PengajaranData> getData() {
        return data;
    }

    public void setData(List<PengajaranData> data) {
        this.data = data;
    }
}
