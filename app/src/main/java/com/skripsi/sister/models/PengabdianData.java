package com.skripsi.sister.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PengabdianData implements Parcelable {

    @SerializedName("id_pengabdian")
    @Expose
    private String id_pengabdian;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("skim")
    @Expose
    private String skim;
    @SerializedName("thn_pelaksanaan")
    @Expose
    private String thnpelaksanaan;
    @SerializedName("lama_kegiatan")
    @Expose
    private String lamakegiatan;

    protected PengabdianData(Parcel in) {
        id_pengabdian = in.readString();
        judul = in.readString();
        skim = in.readString();
        thnpelaksanaan = in.readString();
        lamakegiatan = in.readString();
    }

    public static final Creator<PengabdianData> CREATOR = new Creator<PengabdianData>() {
        @Override
        public PengabdianData createFromParcel(Parcel in) {
            return new PengabdianData(in);
        }

        @Override
        public PengabdianData[] newArray(int size) {
            return new PengabdianData[size];
        }
    };

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getSkim() {
        return skim;
    }

    public void setSkim(String skim) {
        this.skim = skim;
    }

    public String getThnpelaksanaan() {
        return thnpelaksanaan;
    }

    public void setThnpelaksanaan(String thnpelaksanaan) {
        this.thnpelaksanaan = thnpelaksanaan;
    }

    public String getLamakegiatan() {
        return lamakegiatan;
    }

    public void setLamakegiatan(String lamakegiatan) {
        this.lamakegiatan = lamakegiatan;
    }

    public String getId_pengabdian() {
        return id_pengabdian;
    }

    public void setId_pengabdian(String id_pengabdian) {
        this.id_pengabdian = id_pengabdian;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id_pengabdian);
        dest.writeString(judul);
        dest.writeString(skim);
        dest.writeString(thnpelaksanaan);
        dest.writeString(lamakegiatan);
    }
}
