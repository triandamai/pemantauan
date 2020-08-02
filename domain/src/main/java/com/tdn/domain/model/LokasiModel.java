package com.tdn.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.object.LokasiObject;

public class LokasiModel extends BaseModel {
    @SerializedName("id_lokasi")
    @Expose
    private String idLokasi;
    @SerializedName("id_pegawai")
    @Expose
    private String idPegawai;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nip")
    @Expose
    private String nip;
    @SerializedName("nrp")
    @Expose
    private String nrp;
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
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("no_hp")
    @Expose
    private String noHp;

    public String getIdLokasi() {
        return idLokasi;
    }

    public void setIdLokasi(String idLokasi) {
        this.idLokasi = idLokasi;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    @Override
    public String toString() {
        return "LokasiModel{" +
                "idLokasi='" + idLokasi + '\'' +
                ", idPegawai='" + idPegawai + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", id='" + id + '\'' +
                ", nip='" + nip + '\'' +
                ", nrp='" + nrp + '\'' +
                ", namaLengkap='" + namaLengkap + '\'' +
                ", golonganPangkat='" + golonganPangkat + '\'' +
                ", tmt='" + tmt + '\'' +
                ", jabatan='" + jabatan + '\'' +
                ", alamatTinggal='" + alamatTinggal + '\'' +
                ", password='" + password + '\'' +
                ", noHp='" + noHp + '\'' +
                '}';
    }

    @Override
    public Object ToObject() {
        LokasiObject o = new LokasiObject();
        o.setAlamatTinggal(alamatTinggal);
        o.setCreatedAt(createdAt);
        o.setGolonganPangkat(golonganPangkat);
        o.setId(id);
        o.setIdLokasi(idLokasi);
        o.setIdPegawai(idPegawai);
        o.setJabatan(jabatan);
        o.setLat(lat);
        o.setLng(lng);
        o.setNamaLengkap(namaLengkap);
        o.setNip(nip);
        o.setNoHp(noHp);
        o.setNrp(nrp);
        o.setTmt(tmt);
        o.setUpdatedAt(updatedAt);
        return o;
    }
}
