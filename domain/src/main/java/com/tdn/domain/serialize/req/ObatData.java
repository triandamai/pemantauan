package com.tdn.domain.serialize.req;

import com.google.gson.annotations.SerializedName;
import com.tdn.domain.model.ObatModel;
import com.tdn.domain.object.ObatObject;

public class ObatData {

    @SerializedName("obat_jual")
    private String obatJual;

    @SerializedName("obat_stok")
    private String obatStok;

    @SerializedName("obat_nama")
    private String obatNama;

    @SerializedName("obat_id")
    private String obatId;

    @SerializedName("obat_beli")
    private String obatBeli;

    public void setObatJual(String obatJual) {
        this.obatJual = obatJual;
    }

    public String getObatJual() {
        return obatJual;
    }

    public void setObatStok(String obatStok) {
        this.obatStok = obatStok;
    }

    public String getObatStok() {
        return obatStok;
    }

    public void setObatNama(String obatNama) {
        this.obatNama = obatNama;
    }

    public String getObatNama() {
        return obatNama;
    }

    public void setObatId(String obatId) {
        this.obatId = obatId;
    }

    public String getObatId() {
        return obatId;
    }

    public void setObatBeli(String obatBeli) {
        this.obatBeli = obatBeli;
    }

    public String getObatBeli() {
        return obatBeli;
    }


    @Override
    public String toString() {
        return
                "ObatData{" +
                        "obat_jual = '" + obatJual + '\'' +
                        ",obat_stok = '" + obatStok + '\'' +
                        ",obat_nama = '" + obatNama + '\'' +
                        ",obat_id = '" + obatId + '\'' +
                        ",obat_beli = '" + obatBeli + '\'' +
                        "}";
    }
}