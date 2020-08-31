package com.tdn.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JumlahPegawaiModel {

    @SerializedName("jumlah")
    @Expose
    private String jumlah;

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return "JumlahPegawaiModel{" +
                "jumlah='" + jumlah + '\'' +
                '}';
    }
}
