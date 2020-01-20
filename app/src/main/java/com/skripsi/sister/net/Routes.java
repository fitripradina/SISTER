package com.skripsi.sister.net;

import com.skripsi.sister.models.AlamatResponse;
import com.skripsi.sister.models.DeleteResponse;
import com.skripsi.sister.models.InsertResponse;
import com.skripsi.sister.models.JabatanResponse;
import com.skripsi.sister.models.KeluargaResponse;
import com.skripsi.sister.models.KepegawaianResponse;
import com.skripsi.sister.models.KependudukanResponse;
import com.skripsi.sister.models.PangkatResponse;
import com.skripsi.sister.models.PatenResponse;
import com.skripsi.sister.models.PendidikanResponse;
import com.skripsi.sister.models.PenelitianResponse;
import com.skripsi.sister.models.PengabdianResponse;
import com.skripsi.sister.models.PengajaranResponse;
import com.skripsi.sister.models.ProfileResponse;
import com.skripsi.sister.models.PublikasiResponse;
import com.skripsi.sister.models.UpdateResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Routes {
    @FormUrlEncoded
    @POST("login.php")
    Call<ProfileResponse> postLogin(@Field("email") String email,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("getkependudukan.php")
    Call<KependudukanResponse> getKependudukan(@Field("id_profile_fk") String id_profile_fk);

    @FormUrlEncoded
    @POST("getkeluarga.php")
    Call<KeluargaResponse> getKeluarga(@Field("id_profile_fk") String id_profile_fk);

    @FormUrlEncoded
    @POST("getalamatkontak.php")
    Call<AlamatResponse> getAlamat(@Field("id_profile_fk") String id_profile_fk);

    @FormUrlEncoded
    @POST("getkepegawaian.php")
    Call<KepegawaianResponse> getKepegawaian(@Field("id_profile_fk") String id_profile_fk);

//    -----------------------------//

    @FormUrlEncoded
    @POST("getjabatanfungsional.php")
    Call<JabatanResponse> getJabatan(@Field("id_profile_fk") String id_profile_fk);

    @FormUrlEncoded
    @POST("getkepangkatan.php")
    Call<PangkatResponse> getPangkat(@Field("id_profile_fk") String id_profile_fk);

    @FormUrlEncoded
    @POST("getpendidikanformal.php")
    Call<PendidikanResponse> getPendidikan(@Field("id_profile_fk") String id_profile_fk);

    @FormUrlEncoded
    @POST("getpengajaran.php")
    Call<PengajaranResponse> getPengajaran(@Field("id_profile_fk") String id_profile_fk);

    @FormUrlEncoded
    @POST("getpenelitian.php")
    Call<PenelitianResponse> getPenelitian(@Field("id_profile_fk") String id_profile_fk);


    @FormUrlEncoded
    @POST("getpublikasikarya.php")
    Call<PublikasiResponse> getPublikasi(@Field("id_profile_fk") String id_profile_fk);

    @FormUrlEncoded
    @POST("getpaten.php")
    Call<PatenResponse> getPaten(@Field("id_profile_fk") String id_profile_fk);

    @FormUrlEncoded
    @POST("getpengabdian.php")
    Call<PengabdianResponse> getPengabdian(@Field("id_profile_fk") String id_profile_fk);

    //    -----------------------------//

    @FormUrlEncoded
    @POST("insertpenelitian.php")
    Call<InsertResponse> insertPenelitian(@Field("id_profile_fk") String id_profile_fk,
                                          @Field("judul") String judul,
                                          @Field("skim") String skim,
                                          @Field("thn_pelaksanaan") String thn_pelaksanaan,
                                          @Field("lama_kegiatan") String lama_kegiatan);

    @FormUrlEncoded
    @POST("insertpaten.php")
    Call<InsertResponse> insertPaten (@Field("id_profile_fk") String id_profile_fk,
                                          @Field("judul") String judul,
                                          @Field("jenis") String jenis,
                                          @Field("tgl_terbit") String tgl_terbit);

    //update penelitian
    @FormUrlEncoded
    @POST("updatepenelitian.php")
    Call<UpdateResponse> updatePenelitian(@Field("id_profile_fk") String id_profile_fk,
                                          @Field("id_penelitian") String id_penelitian,
                                          @Field("judul") String judul,
                                          @Field("skim") String skim,
                                          @Field("thn_pelaksanaan") String thn_pelaksanaan,
                                          @Field("lama_kegiatan") String lama_kegiatan);

    //delete penelitian
    @FormUrlEncoded
    @POST("deletepenelitian.php")
    Call<DeleteResponse> deletePenelitian(@Field("id_profile_fk") String id_profile_fk,
                                          @Field("id_penelitian") String id_penelitian);
}
