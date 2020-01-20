package com.skripsi.sister.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PangkatData {
    @SerializedName("gol_pangkat")
    @Expose
    private String golonganpangkat;
    @SerializedName("nomor_sk")
    @Expose
    private String nomorsk;
    @SerializedName("terhitung_tgl")
    @Expose
    private String terhitungtgl;

    public String getGolonganpangkat() {
        return golonganpangkat;
    }

    public void setGolonganpangkat(String golonganpangkat) {
        this.golonganpangkat = golonganpangkat;
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
