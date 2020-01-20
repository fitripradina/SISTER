package com.skripsi.sister.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PendidikanData {
@SerializedName("jenjang")
@Expose
private String jenjang;
@SerializedName("gelar")
@Expose
private String gelar;
@SerializedName("bid_studi")
@Expose
private String bidangstudi;
@SerializedName("perguruan_tinggi")
@Expose
private String perguruantinggi;
@SerializedName("tahun_lulus")
@Expose
private String tahunlulus;
private List<PendidikanData> data = null;

    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
    }

    public String getGelar() {
        return gelar;
    }

    public void setGelar(String gelar) {
        this.gelar = gelar;
    }

    public String getBidangstudi() {
        return bidangstudi;
    }

    public void setBidangstudi(String bidangstudi) {
        this.bidangstudi = bidangstudi;
    }

    public String getPerguruantinggi() {
        return perguruantinggi;
    }

    public void setPerguruantinggi(String perguruantinggi) {
        this.perguruantinggi = perguruantinggi;
    }

    public String getTahunlulus() {
        return tahunlulus;
    }

    public void setTahunlulus(String tahunlulus) {
        this.tahunlulus = tahunlulus;
    }

    public List<PendidikanData> getData() {
        return data;
    }

    public void setData(List<PendidikanData> data) {
        this.data = data;
    }
}
