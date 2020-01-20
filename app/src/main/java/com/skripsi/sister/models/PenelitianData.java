package com.skripsi.sister.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PenelitianData implements Parcelable {


        @SerializedName("id_penelitian")
        @Expose
        private String id_penelitian;
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


    private PenelitianData(Parcel in) {
        id_penelitian = in.readString();
        judul = in.readString();
        skim = in.readString();
        thnpelaksanaan = in.readString();
        lamakegiatan = in.readString();
    }

    public static final Creator<PenelitianData> CREATOR = new Creator<PenelitianData>() {
        @Override
        public PenelitianData createFromParcel(Parcel in) {
            return new PenelitianData(in);
        }

        @Override
        public PenelitianData[] newArray(int size) {
            return new PenelitianData[size];
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

    public String getId_penelitian() {
        return id_penelitian;
    }

    public void setId_penelitian(String id_penelitian) {
        this.id_penelitian = id_penelitian;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id_penelitian);
        dest.writeString(judul);
        dest.writeString(skim);
        dest.writeString(thnpelaksanaan);
        dest.writeString(lamakegiatan);
    }
}
