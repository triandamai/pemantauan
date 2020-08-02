package com.tdn.domain.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.model.PenjualanTempModel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PenjualanTempObject extends RealmObject {

    @PrimaryKey
    private String tempId;

    private String tempIdStok;

    private String tempJumlah;

    private String tempTotalharga;

    private String detailId;

    private String detailIdTransaksi;

    private String detailObatId;

    private String detailSatuanBeli;

    private String detailHargaJual;

    private String detailHargaBeli;

    private String detailDiskon;

    private String detailExpired;

    private String detailTanggalTerima;

    private String detailJumlah;

    private String detailHarga;

    private String jmlUpdate;

    private String obatId;

    private String obatNama;

    private String obatStok;

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getTempIdStok() {
        return tempIdStok;
    }

    public void setTempIdStok(String tempIdStok) {
        this.tempIdStok = tempIdStok;
    }

    public String getTempJumlah() {
        return tempJumlah;
    }

    public void setTempJumlah(String tempJumlah) {
        this.tempJumlah = tempJumlah;
    }

    public String getTempTotalharga() {
        return tempTotalharga;
    }

    public void setTempTotalharga(String tempTotalharga) {
        this.tempTotalharga = tempTotalharga;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getDetailIdTransaksi() {
        return detailIdTransaksi;
    }

    public void setDetailIdTransaksi(String detailIdTransaksi) {
        this.detailIdTransaksi = detailIdTransaksi;
    }

    public String getDetailObatId() {
        return detailObatId;
    }

    public void setDetailObatId(String detailObatId) {
        this.detailObatId = detailObatId;
    }

    public String getDetailSatuanBeli() {
        return detailSatuanBeli;
    }

    public void setDetailSatuanBeli(String detailSatuanBeli) {
        this.detailSatuanBeli = detailSatuanBeli;
    }

    public String getDetailHargaJual() {
        return detailHargaJual;
    }

    public void setDetailHargaJual(String detailHargaJual) {
        this.detailHargaJual = detailHargaJual;
    }

    public String getDetailHargaBeli() {
        return detailHargaBeli;
    }

    public void setDetailHargaBeli(String detailHargaBeli) {
        this.detailHargaBeli = detailHargaBeli;
    }

    public String getDetailDiskon() {
        return detailDiskon;
    }

    public void setDetailDiskon(String detailDiskon) {
        this.detailDiskon = detailDiskon;
    }

    public String getDetailExpired() {
        return detailExpired;
    }

    public void setDetailExpired(String detailExpired) {
        this.detailExpired = detailExpired;
    }

    public String getDetailTanggalTerima() {
        return detailTanggalTerima;
    }

    public void setDetailTanggalTerima(String detailTanggalTerima) {
        this.detailTanggalTerima = detailTanggalTerima;
    }

    public String getDetailJumlah() {
        return detailJumlah;
    }

    public void setDetailJumlah(String detailJumlah) {
        this.detailJumlah = detailJumlah;
    }

    public String getDetailHarga() {
        return detailHarga;
    }

    public void setDetailHarga(String detailHarga) {
        this.detailHarga = detailHarga;
    }

    public String getJmlUpdate() {
        return jmlUpdate;
    }

    public void setJmlUpdate(String jmlUpdate) {
        this.jmlUpdate = jmlUpdate;
    }

    public String getObatId() {
        return obatId;
    }

    public void setObatId(String obatId) {
        this.obatId = obatId;
    }

    public String getObatNama() {
        return obatNama;
    }

    public void setObatNama(String obatNama) {
        this.obatNama = obatNama;
    }

    public String getObatStok() {
        return obatStok;
    }

    public void setObatStok(String obatStok) {
        this.obatStok = obatStok;
    }

    @Override
    public String toString() {
        return "PenjualanTempModel{" +
                "tempId='" + tempId + '\'' +
                ", tempIdStok='" + tempIdStok + '\'' +
                ", tempJumlah='" + tempJumlah + '\'' +
                ", tempTotalharga='" + tempTotalharga + '\'' +
                ", detailId='" + detailId + '\'' +
                ", detailIdTransaksi='" + detailIdTransaksi + '\'' +
                ", detailObatId='" + detailObatId + '\'' +
                ", detailSatuanBeli='" + detailSatuanBeli + '\'' +
                ", detailHargaJual='" + detailHargaJual + '\'' +
                ", detailHargaBeli='" + detailHargaBeli + '\'' +
                ", detailDiskon='" + detailDiskon + '\'' +
                ", detailExpired='" + detailExpired + '\'' +
                ", detailTanggalTerima='" + detailTanggalTerima + '\'' +
                ", detailJumlah='" + detailJumlah + '\'' +
                ", detailHarga='" + detailHarga + '\'' +
                ", jmlUpdate='" + jmlUpdate + '\'' +
                ", obatId='" + obatId + '\'' +
                ", obatNama='" + obatNama + '\'' +
                ", obatStok='" + obatStok + '\'' +
                '}';
    }

    public Object ToModel() {
        PenjualanTempModel o = new PenjualanTempModel();
        o.setTempTotalharga(tempTotalharga);
        o.setTempJumlah(tempJumlah);
        o.setTempId(tempId);
        o.setTempIdStok(tempIdStok);
        o.setDetailDiskon(detailDiskon);
        o.setDetailExpired(detailExpired);
        o.setDetailHarga(detailHarga);
        o.setDetailHargaBeli(detailHargaBeli);
        o.setDetailHargaJual(detailHargaJual);
        o.setDetailId(detailId);
        o.setDetailIdTransaksi(detailIdTransaksi);
        o.setDetailJumlah(detailJumlah);
        o.setDetailObatId(obatId);
        o.setDetailSatuanBeli(detailSatuanBeli);
        o.setDetailTanggalTerima(detailTanggalTerima);
        o.setJmlUpdate(jmlUpdate);
        o.setObatId(obatId);
        o.setObatNama(obatNama);
        o.setObatStok(obatStok);

        return o;
    }
}
