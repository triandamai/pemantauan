package com.tdn.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.object.PenjualanTempObject;

public class PenjualanTempModel extends BaseModel {

    @SerializedName("temp_id")
    @Expose
    private String tempId;
    @SerializedName("temp_id_stok")
    @Expose
    private String tempIdStok;
    @SerializedName("temp_jumlah")
    @Expose
    private String tempJumlah;
    @SerializedName("temp_totalharga")
    @Expose
    private String tempTotalharga;
    @SerializedName("detail_id")
    @Expose
    private String detailId;
    @SerializedName("detail_id_transaksi")
    @Expose
    private String detailIdTransaksi;
    @SerializedName("detail_obat_id")
    @Expose
    private String detailObatId;
    @SerializedName("detail_satuan_beli")
    @Expose
    private String detailSatuanBeli;
    @SerializedName("detail_harga_jual")
    @Expose
    private String detailHargaJual;
    @SerializedName("detail_harga_beli")
    @Expose
    private String detailHargaBeli;
    @SerializedName("detail_diskon")
    @Expose
    private String detailDiskon;
    @SerializedName("detail_expired")
    @Expose
    private String detailExpired;
    @SerializedName("detail_tanggal_terima")
    @Expose
    private String detailTanggalTerima;
    @SerializedName("detail_jumlah")
    @Expose
    private String detailJumlah;
    @SerializedName("detail_harga")
    @Expose
    private String detailHarga;
    @SerializedName("jml_update")
    @Expose
    private String jmlUpdate;
    @SerializedName("obat_id")
    @Expose
    private String obatId;
    @SerializedName("obat_nama")
    @Expose
    private String obatNama;
    @SerializedName("obat_stok")
    @Expose
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

    @Override
    public Object ToObject() {
        PenjualanTempObject o = new PenjualanTempObject();
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