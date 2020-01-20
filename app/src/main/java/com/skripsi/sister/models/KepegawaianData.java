package com.skripsi.sister.models;

import com.google.gson.annotations.SerializedName;

public class KepegawaianData{

	@SerializedName("lembaga_pengangkat")
	private String lembagaPengangkat;

	@SerializedName("status_kepegawaian")
	private String statusKepegawaian;

	@SerializedName("nosk_tmmd")
	private String noskTmmd;

	@SerializedName("sumber-gaji")
	private String sumberGaji;

	@SerializedName("pangkat_gol")
	private String pangkatGol;

	@SerializedName("status_keaktifan")
	private String statusKeaktifan;

	@SerializedName("nosk_cpns")
	private String noskCpns;

	@SerializedName("tgl_tmmd")
	private String tglTmmd;

	@SerializedName("prog_studi")
	private String progStudi;

	@SerializedName("id_kepegawaian")
	private String idKepegawaian;

	@SerializedName("nip")
	private String nip;

	@SerializedName("id_profile_fk")
	private String idProfileFk;

	@SerializedName("tgl_skcpns")
	private String tglSkcpns;

	public String getLembagaPengangkat() {
		return lembagaPengangkat;
	}

	public void setLembagaPengangkat(String lembagaPengangkat) {
		this.lembagaPengangkat = lembagaPengangkat;
	}

	public String getStatusKepegawaian() {
		return statusKepegawaian;
	}

	public void setStatusKepegawaian(String statusKepegawaian) {
		this.statusKepegawaian = statusKepegawaian;
	}

	public String getNoskTmmd() {
		return noskTmmd;
	}

	public void setNoskTmmd(String noskTmmd) {
		this.noskTmmd = noskTmmd;
	}

	public String getSumberGaji() {
		return sumberGaji;
	}

	public void setSumberGaji(String sumberGaji) {
		this.sumberGaji = sumberGaji;
	}

	public String getPangkatGol() {
		return pangkatGol;
	}

	public void setPangkatGol(String pangkatGol) {
		this.pangkatGol = pangkatGol;
	}

	public String getStatusKeaktifan() {
		return statusKeaktifan;
	}

	public void setStatusKeaktifan(String statusKeaktifan) {
		this.statusKeaktifan = statusKeaktifan;
	}

	public String getNoskCpns() {
		return noskCpns;
	}

	public void setNoskCpns(String noskCpns) {
		this.noskCpns = noskCpns;
	}

	public String getTglTmmd() {
		return tglTmmd;
	}

	public void setTglTmmd(String tglTmmd) {
		this.tglTmmd = tglTmmd;
	}

	public String getProgStudi() {
		return progStudi;
	}

	public void setProgStudi(String progStudi) {
		this.progStudi = progStudi;
	}

	public String getIdKepegawaian() {
		return idKepegawaian;
	}

	public void setIdKepegawaian(String idKepegawaian) {
		this.idKepegawaian = idKepegawaian;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getIdProfileFk() {
		return idProfileFk;
	}

	public void setIdProfileFk(String idProfileFk) {
		this.idProfileFk = idProfileFk;
	}

	public String getTglSkcpns() {
		return tglSkcpns;
	}

	public void setTglSkcpns(String tglSkcpns) {
		this.tglSkcpns = tglSkcpns;
	}
}