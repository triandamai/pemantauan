package com.tdn.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.object.ObatObject;

public class ObatModel extends BaseModel {

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
    @SerializedName("obat_id")
    @Expose
    private String obatId;
    @SerializedName("obat_nama")
    @Expose
    private String obatNama;
    @SerializedName("obat_stok")
    @Expose
    private String obatStok;
    @SerializedName("pembelian_id")
    @Expose
    private String pembelianId;
    @SerializedName("pembelian_faktur")
    @Expose
    private String pembelianFaktur;
    @SerializedName("pembelian_tanggal_faktur")
    @Expose
    private String pembelianTanggalFaktur;
    @SerializedName("pembelian_tanggal_masuk")
    @Expose
    private String pembelianTanggalMasuk;
    @SerializedName("pembelian_id_transaksi")
    @Expose
    private String pembelianIdTransaksi;
    @SerializedName("pembelian_tanggal")
    @Expose
    private String pembelianTanggal;
    @SerializedName("pembelian_id_supplier")
    @Expose
    private String pembelianIdSupplier;
    @SerializedName("pembelian_subtotal")
    @Expose
    private String pembelianSubtotal;
    @SerializedName("supplier_id")
    @Expose
    private String supplierId;
    @SerializedName("supplier_nama")
    @Expose
    private String supplierNama;
    @SerializedName("supplier_alamat")
    @Expose
    private String supplierAlamat;
    @SerializedName("supplier_telp")
    @Expose
    private String supplierTelp;

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

    public String getPembelianId() {
        return pembelianId;
    }

    public void setPembelianId(String pembelianId) {
        this.pembelianId = pembelianId;
    }

    public String getPembelianFaktur() {
        return pembelianFaktur;
    }

    public void setPembelianFaktur(String pembelianFaktur) {
        this.pembelianFaktur = pembelianFaktur;
    }

    public String getPembelianTanggalFaktur() {
        return pembelianTanggalFaktur;
    }

    public void setPembelianTanggalFaktur(String pembelianTanggalFaktur) {
        this.pembelianTanggalFaktur = pembelianTanggalFaktur;
    }

    public String getPembelianTanggalMasuk() {
        return pembelianTanggalMasuk;
    }

    public void setPembelianTanggalMasuk(String pembelianTanggalMasuk) {
        this.pembelianTanggalMasuk = pembelianTanggalMasuk;
    }

    public String getPembelianIdTransaksi() {
        return pembelianIdTransaksi;
    }

    public void setPembelianIdTransaksi(String pembelianIdTransaksi) {
        this.pembelianIdTransaksi = pembelianIdTransaksi;
    }

    public String getPembelianTanggal() {
        return pembelianTanggal;
    }

    public void setPembelianTanggal(String pembelianTanggal) {
        this.pembelianTanggal = pembelianTanggal;
    }

    public String getPembelianIdSupplier() {
        return pembelianIdSupplier;
    }

    public void setPembelianIdSupplier(String pembelianIdSupplier) {
        this.pembelianIdSupplier = pembelianIdSupplier;
    }

    public String getPembelianSubtotal() {
        return pembelianSubtotal;
    }

    public void setPembelianSubtotal(String pembelianSubtotal) {
        this.pembelianSubtotal = pembelianSubtotal;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierNama() {
        return supplierNama;
    }

    public void setSupplierNama(String supplierNama) {
        this.supplierNama = supplierNama;
    }

    public String getSupplierAlamat() {
        return supplierAlamat;
    }

    public void setSupplierAlamat(String supplierAlamat) {
        this.supplierAlamat = supplierAlamat;
    }

    public String getSupplierTelp() {
        return supplierTelp;
    }

    public void setSupplierTelp(String supplierTelp) {
        this.supplierTelp = supplierTelp;
    }

    @Override
    public String toString() {
        return "ObatModel{" +
                "detailId='" + detailId + '\'' +
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
                ", obatId='" + obatId + '\'' +
                ", obatNama='" + obatNama + '\'' +
                ", obatStok='" + obatStok + '\'' +
                ", pembelianId='" + pembelianId + '\'' +
                ", pembelianFaktur='" + pembelianFaktur + '\'' +
                ", pembelianTanggalFaktur='" + pembelianTanggalFaktur + '\'' +
                ", pembelianTanggalMasuk='" + pembelianTanggalMasuk + '\'' +
                ", pembelianIdTransaksi='" + pembelianIdTransaksi + '\'' +
                ", pembelianTanggal='" + pembelianTanggal + '\'' +
                ", pembelianIdSupplier='" + pembelianIdSupplier + '\'' +
                ", pembelianSubtotal='" + pembelianSubtotal + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", supplierNama='" + supplierNama + '\'' +
                ", supplierAlamat='" + supplierAlamat + '\'' +
                ", supplierTelp='" + supplierTelp + '\'' +
                '}';
    }

    @Override
    public Object ToObject() {
        ObatObject o = new ObatObject();
        o.setObatStok(obatStok);
        o.setObatNama(obatNama);
        o.setObatId(obatId);
        o.setDetailDiskon(detailDiskon);
        o.setDetailExpired(detailExpired);
        o.setDetailHarga(detailHarga);
        o.setDetailHargaBeli(detailHargaBeli);
        o.setDetailHargaJual(detailHargaJual);
        o.setDetailId(detailId);
        o.setDetailIdTransaksi(detailIdTransaksi);
        o.setDetailJumlah(detailJumlah);
        o.setDetailObatId(detailObatId);
        o.setDetailSatuanBeli(detailSatuanBeli);
        o.setDetailTanggalTerima(detailTanggalTerima);
        o.setPembelianFaktur(pembelianFaktur);
        o.setPembelianId(pembelianId);
        o.setPembelianIdSupplier(pembelianIdSupplier);
        o.setPembelianIdTransaksi(pembelianIdTransaksi);
        o.setPembelianSubtotal(pembelianSubtotal);
        o.setPembelianTanggal(pembelianTanggal);
        o.setPembelianTanggalFaktur(pembelianTanggalFaktur);
        o.setPembelianTanggalMasuk(pembelianTanggalMasuk);
        return o;
    }

}
