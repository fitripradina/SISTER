package com.skripsi.sister.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JabatanData {
    @SerializedName("jabatan_fungsional")
    @Expose
    private String jabatanfungsional;
    @SerializedName("nomor_sk")
    @Expose
    private String nomorsk;
    @SerializedName("terhitung_tgl")
    @Expose
    private String terhitungtgl;

    public String getJabatanfungsional() {
        return jabatanfungsional;
    }

    public void setJabatanfungsional(String jabatanfungsional) {
        this.jabatanfungsional = jabatanfungsional;
    }

    public String getNomorsk() {
        return nomorsk;
    }

    public void setNomorsk(String nomorsk) {
        this.nomorsk = nomorsk;
    }

    public String getTerhitungtgl() {
        return terhitungtgl;
    }

    public void setTerhitungtgl(String terhitungtgl) {
        this.terhitungtgl = terhitungtgl;
    }
}
