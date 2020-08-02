package com.tdn.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.object.HomeObject;

public class HomeModel extends BaseModel {
    @SerializedName("pembelian")
    @Expose
    private Integer pembelian;
    @SerializedName("penjualan")
    @Expose
    private Integer penjualan;
    @SerializedName("nama_apotek")
    @Expose
    private String namaApotek;
    @SerializedName("alamat_apotek")
    @Expose
    private String alamatApotek;
    @SerializedName("notifikasi_expired")
    @Expose
    private String notifikasiExpired;
    @SerializedName("stok_minimal")
    @Expose
    private String stokMinimal;

    public Integer getPembelian() {
        return pembelian;
    }

    public void setPembelian(Integer pembelian) {
        this.pembelian = pembelian;
    }

    public Integer getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(Integer penjualan) {
        this.penjualan = penjualan;
    }

    public String getNamaApotek() {
        return namaApotek;
    }

    public void setNamaApotek(String namaApotek) {
        this.namaApotek = namaApotek;
    }

    public String getAlamatApotek() {
        return alamatApotek;
    }

    public void setAlamatApotek(String alamatApotek) {
        this.alamatApotek = alamatApotek;
    }

    public String getNotifikasiExpired() {
        return notifikasiExpired;
    }

    public void setNotifikasiExpired(String notifikasiExpired) {
        this.notifikasiExpired = notifikasiExpired;
    }

    public String getStokMinimal() {
        return stokMinimal;
    }

    public void setStokMinimal(String stokMinimal) {
        this.stokMinimal = stokMinimal;
    }

    @Override
    public String toString() {
        return "HomeObject{" +
                "pembelian=" + pembelian +
                ", penjualan=" + penjualan +
                ", namaApotek='" + namaApotek + '\'' +
                ", alamatApotek='" + alamatApotek + '\'' +
                ", notifikasiExpired='" + notifikasiExpired + '\'' +
                ", stokMinimal='" + stokMinimal + '\'' +
                '}';
    }

    @Override
    public Object ToObject() {
        HomeObject o = new HomeObject();
        o.setAlamatApotek(alamatApotek);
        o.setNamaApotek(namaApotek);
        o.setNotifikasiExpired(notifikasiExpired);
        o.setPembelian(pembelian);
        o.setPenjualan(penjualan);
        o.setStokMinimal(stokMinimal);
        o.setId(1);
        return o;
    }
}
