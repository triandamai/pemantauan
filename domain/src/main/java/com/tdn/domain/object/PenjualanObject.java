package com.tdn.domain.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.model.PenjualanModel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PenjualanObject extends RealmObject {
    @PrimaryKey
    private String penjualanId;

    private String penjualanIdTransaksi;

    private String penjualanTanggal;

    private String penjualanSubtotal;

    public String getPenjualanId() {
        return penjualanId;
    }

    public void setPenjualanId(String penjualanId) {
        this.penjualanId = penjualanId;
    }

    public String getPenjualanIdTransaksi() {
        return penjualanIdTransaksi;
    }

    public void setPenjualanIdTransaksi(String penjualanIdTransaksi) {
        this.penjualanIdTransaksi = penjualanIdTransaksi;
    }

    public String getPenjualanTanggal() {
        return penjualanTanggal;
    }

    public void setPenjualanTanggal(String penjualanTanggal) {
        this.penjualanTanggal = penjualanTanggal;
    }

    public String getPenjualanSubtotal() {
        return penjualanSubtotal;
    }

    public void setPenjualanSubtotal(String penjualanSubtotal) {
        this.penjualanSubtotal = penjualanSubtotal;
    }

    @Override
    public String toString() {
        return "ResponseGetPenjualan{" +
                "penjualanId='" + penjualanId + '\'' +
                ", penjualanIdTransaksi='" + penjualanIdTransaksi + '\'' +
                ", penjualanTanggal='" + penjualanTanggal + '\'' +
                ", penjualanSubtotal='" + penjualanSubtotal + '\'' +
                '}';
    }

    public Object ToModel() {
        PenjualanModel o = new PenjualanModel();
        o.setPenjualanId(penjualanId);
        o.setPenjualanIdTransaksi(penjualanIdTransaksi);
        o.setPenjualanSubtotal(penjualanSubtotal);
        o.setPenjualanTanggal(penjualanTanggal);
        return o;
    }
}
