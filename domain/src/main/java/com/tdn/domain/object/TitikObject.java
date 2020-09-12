package com.tdn.domain.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.model.LokasiModel;
import com.tdn.domain.model.TitikModel;

public class TitikObject {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("detail")
    @Expose
    private String detail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Object ToModel() {
        TitikModel o = new TitikModel();
        o.setId(id);
        o.setDetail(detail);
        o.setLat(lat);
        o.setLng(lng);
        o.setNama(nama);
        return o;
    }

}