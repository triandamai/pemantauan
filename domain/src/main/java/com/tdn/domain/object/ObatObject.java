package com.tdn.domain.object;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ObatObject extends RealmObject {

    @PrimaryKey
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

    private String obatId;

    private String obatNama;

    private String obatStok;

    private String pembelianId;

    private String pembelianFaktur;

    private String pembelianTanggalFaktur;

    private String pembelianTanggalMasuk;

    private String pembelianIdTransaksi;

    private String pembelianTanggal;

    private String pembelianIdSupplier;

    private String pembelianSubtotal;

    private String supplierId;

    private String supplierNama;

    private String supplierAlamat;

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


    public Object ToModel() {
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
