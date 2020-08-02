package com.tdn.domain.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.model.HomeModel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class HomeObject extends RealmObject {
    @PrimaryKey
    private Integer id;
    private Integer pembelian;

    private Integer penjualan;

    private String namaApotek;

    private String alamatApotek;

    private String notifikasiExpired;

    private String stokMinimal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
                "id=" + id +
                ", pembelian=" + pembelian +
                ", penjualan=" + penjualan +
                ", namaApotek='" + namaApotek + '\'' +
                ", alamatApotek='" + alamatApotek + '\'' +
                ", notifikasiExpired='" + notifikasiExpired + '\'' +
                ", stokMinimal='" + stokMinimal + '\'' +
                '}';
    }

    public Object ToModel() {
        HomeModel o = new HomeModel();
        o.setAlamatApotek(alamatApotek);
        o.setNamaApotek(namaApotek);
        o.setNotifikasiExpired(notifikasiExpired);
        o.setPembelian(pembelian);
        o.setPenjualan(penjualan);
        o.setStokMinimal(stokMinimal);

        return o;
    }
}
