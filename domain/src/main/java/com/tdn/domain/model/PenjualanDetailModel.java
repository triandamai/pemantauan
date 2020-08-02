package com.tdn.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.object.PenjualanDetailObject;

public class PenjualanDetailModel extends BaseModel {
    @SerializedName("detail_id")
    @Expose
    private String detailId;
    @SerializedName("detail_id_transaksi")
    @Expose
    private String detailIdTransaksi;
    @SerializedName("detail_id_stok")
    @Expose
    private String detailIdStok;
    @SerializedName("detail_jumlah")
    @Expose
    private String detailJumlah;
    @SerializedName("detail_harga")
    @Expose
    private String detailHarga;
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

    public String getDetailIdStok() {
        return detailIdStok;
    }

    public void setDetailIdStok(String detailIdStok) {
        this.detailIdStok = detailIdStok;
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
        return "PenjualanDetailModel{" +
                "detailId='" + detailId + '\'' +
                ", detailIdTransaksi='" + detailIdTransaksi + '\'' +
                ", detailIdStok='" + detailIdStok + '\'' +
                ", detailJumlah='" + detailJumlah + '\'' +
                ", detailHarga='" + detailHarga + '\'' +
                ", detailObatId='" + detailObatId + '\'' +
                ", detailSatuanBeli='" + detailSatuanBeli + '\'' +
                ", detailHargaJual='" + detailHargaJual + '\'' +
                ", detailHargaBeli='" + detailHargaBeli + '\'' +
                ", detailDiskon='" + detailDiskon + '\'' +
                ", detailExpired='" + detailExpired + '\'' +
                ", detailTanggalTerima='" + detailTanggalTerima + '\'' +
                ", jmlUpdate='" + jmlUpdate + '\'' +
                ", obatId='" + obatId + '\'' +
                ", obatNama='" + obatNama + '\'' +
                ", obatStok='" + obatStok + '\'' +
                '}';
    }

    @Override
    public Object ToObject() {
        PenjualanDetailObject o = new PenjualanDetailObject();
        o.setDetailHarga(detailHarga);
        o.setDetailId(detailId);
        o.setDetailIdTransaksi(detailIdTransaksi);
        o.setDetailJumlah(detailJumlah);
        o.setDetailObatId(detailObatId);
        o.setObatNama(obatNama);
        o.setObatStok(obatStok);
        o.setObatId(obatId);
        return o;
    }

}
