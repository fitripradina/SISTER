package com.skripsi.sister.models;

import com.google.gson.annotations.SerializedName;

public class AlamatData{

	@SerializedName("provinsi")
	private String provinsi;

	@SerializedName("rt")
	private String rt;

	@SerializedName("dusun")
	private String dusun;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("rw")
	private String rw;

	@SerializedName("id_alamat_kontak")
	private String idAlamatKontak;

	@SerializedName("kota_kabupaten")
	private String kotaKabupaten;

	@SerializedName("kelurahan")
	private String kelurahan;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("id_profile_fk")
	private String idProfileFk;

	@SerializedName("kodepos")
	private String kodepos;

	@SerializedName("no_telpon")
	private String noTelpon;

	@SerializedName("email")
	private String email;

	public String getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	public String getDusun() {
		return dusun;
	}

	public void setDusun(String dusun) {
		this.dusun = dusun;
	}

	public String getNoHp() {
		return noHp;
	}

	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}

	public String getRw() {
		return rw;
	}

	public void setRw(String rw) {
		this.rw = rw;
	}

	public String getIdAlamatKontak() {
		return idAlamatKontak;
	}

	public void setIdAlamatKontak(String idAlamatKontak) {
		this.idAlamatKontak = idAlamatKontak;
	}

	public String getKotaKabupaten() {
		return kotaKabupaten;
	}

	public void setKotaKabupaten(String kotaKabupaten) {
		this.kotaKabupaten = kotaKabupaten;
	}

	public String getKelurahan() {
		return kelurahan;
	}

	public void setKelurahan(String kelurahan) {
		this.kelurahan = kelurahan;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getIdProfileFk() {
		return idProfileFk;
	}

	public void setIdProfileFk(String idProfileFk) {
		this.idProfileFk = idProfileFk;
	}

	public String getKodepos() {
		return kodepos;
	}

	public void setKodepos(String kodepos) {
		this.kodepos = kodepos;
	}

	public String getNoTelpon() {
		return noTelpon;
	}

	public void setNoTelpon(String noTelpon) {
		this.noTelpon = noTelpon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}