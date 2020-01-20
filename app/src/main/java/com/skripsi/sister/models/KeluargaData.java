package com.skripsi.sister.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KeluargaData {
    @SerializedName("status_kawin")
    @Expose
    private String statuskawin;
    @SerializedName("nama_suamiistri")
    @Expose
    private String namasuamiistri;
    @SerializedName("nip_suamiistri")
    @Expose
    private String nipsuamiistri;
    @SerializedName("pekerjaan_suamiistri")
    @Expose
    private String pekerjaansuamiistri;
    @SerializedName("tgl_pnssuamiistri")
    @Expose
    private String tglpnssuamiistri;

    public String getStatuskawin() {
        return statuskawin;
    }

    public void setStatuskawin(String statuskawin) {
        this.statuskawin = statuskawin;
    }

    public String getNamasuamiistri() {
        return namasuamiistri;
    }

    public void setNamasuamiistri(String namasuamiistri) {
        this.namasuamiistri = namasuamiistri;
    }

    public String getNipsuamiistri() {
        return nipsuamiistri;
    }

    public void setNipsuamiistri(String nipsuamiistri) {
        this.nipsuamiistri = nipsuamiistri;
    }

    public String getPekerjaansuamiistri() {
        return pekerjaansuamiistri;
    }

    public void setPekerjaansuamiistri(String pekerjaansuamiistri) {
        this.pekerjaansuamiistri = pekerjaansuamiistri;
    }

    public String getTglpnssuamiistri() {
        return tglpnssuamiistri;
    }

    public void setTglpnssuamiistri(String tglpnssuamiistri) {
        this.tglpnssuamiistri = tglpnssuamiistri;
    }
}
