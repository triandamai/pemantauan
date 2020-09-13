package com.tdn.domain.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.model.LokasiModel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LokasiObject extends RealmObject {

    @PrimaryKey
    private Integer id;

    private String lat;

    private String lng;

    private String ket;

    private String detail;

    private String tipe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }


    public Object ToModel() {
        LokasiModel o = new LokasiModel();
        o.setDetail(detail);
        o.setId(id);
        o.setKet(ket);
        o.setLat(lat);
        o.setLng(lng);
        o.setTipe(tipe);
        return o;
    }
}
