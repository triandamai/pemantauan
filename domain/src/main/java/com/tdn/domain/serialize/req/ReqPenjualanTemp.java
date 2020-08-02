package com.tdn.domain.serialize.req;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReqPenjualanTemp {
    @SerializedName("temp_id")
    @Expose
    private String tempId;
    @SerializedName("temp_jumlah")
    @Expose
    private String tempJumlah;
    @SerializedName("temp_id_stok")
    @Expose
    private String tempIdStok;
    @SerializedName("temp_total")
    @Expose
    private String tempTotal;

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getTempJumlah() {
        return tempJumlah;
    }

    public void setTempJumlah(String tempJumlah) {
        this.tempJumlah = tempJumlah;
    }

    public String getTempIdStok() {
        return tempIdStok;
    }

    public void setTempIdStok(String tempIdStok) {
        this.tempIdStok = tempIdStok;
    }

    public String getTempTotal() {
        return tempTotal;
    }

    public void setTempTotal(String tempTotal) {
        this.tempTotal = tempTotal;
    }

    @Override
    public String toString() {
        return "ReqPenjualanTemp{" +
                "tempId='" + tempId + '\'' +
                ", tempJumlah='" + tempJumlah + '\'' +
                ", tempIdStok='" + tempIdStok + '\'' +
                ", tempTotal='" + tempTotal + '\'' +
                '}';
    }
}
