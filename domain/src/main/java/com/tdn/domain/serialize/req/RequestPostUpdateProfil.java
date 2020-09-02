package com.tdn.domain.serialize.req;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestPostUpdateProfil {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama_lengkap")
    @Expose
    private String namaLengkap;
    @SerializedName("golongan_pangkat")
    @Expose
    private String golonganPangkat;
    @SerializedName("tmt")
    @Expose
    private String tmt;
    @SerializedName("jabatan")
    @Expose
    private String jabatan;
    @SerializedName("alamat_tinggal")
    @Expose
    private String alamatTinggal;
    @SerializedName("no_hp")
    @Expose
    private String noHp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getGolonganPangkat() {
        return golonganPangkat;
    }

    public void setGolonganPangkat(String golonganPangkat) {
        this.golonganPangkat = golonganPangkat;
    }

    public String getTmt() {
        return tmt;
    }

    public void setTmt(String tmt) {
        this.tmt = tmt;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getAlamatTinggal() {
        return alamatTinggal;
    }

    public void setAlamatTinggal(String alamatTinggal) {
        this.alamatTinggal = alamatTinggal;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
}
