package com.tdn.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.object.PenjualanObject;

public class PenjualanModel extends BaseModel {
    @SerializedName("penjualan_id")
    @Expose
    private String penjualanId;
    @SerializedName("penjualan_id_transaksi")
    @Expose
    private String penjualanIdTransaksi;
    @SerializedName("penjualan_tanggal")
    @Expose
    private String penjualanTanggal;
    @SerializedName("penjualan_subtotal")
    @Expose
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

    @Override
    public Object ToObject() {
        PenjualanObject o = new PenjualanObject();
        o.setPenjualanId(penjualanId);
        o.setPenjualanIdTransaksi(penjualanIdTransaksi);
        o.setPenjualanSubtotal(penjualanSubtotal);
        o.setPenjualanTanggal(penjualanTanggal);
        return o;
    }
}
