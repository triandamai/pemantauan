package com.tdn.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AbsensiNama {

    @SerializedName("karyawan_nama_full")
    @Expose
    private String karyawanNamaFull;

    public String getKaryawanNamaFull() {
        return karyawanNamaFull;
    }

    public void setKaryawanNamaFull(String karyawanNamaFull) {
        this.karyawanNamaFull = karyawanNamaFull;
    }

    @Override
    public String toString() {
        return "AbsensiNama{" +
                "karyawanNamaFull='" + karyawanNamaFull + '\'' +
                '}';
    }
}
