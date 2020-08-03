package com.tdn.domain.serialize.req;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestPostUpdateLocation {
    @SerializedName("id_pegawai")
    @Expose
    private String idPegawai;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
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

    @Override
    public String toString() {
        return "RequestPostUpdateLocation{" +
                "idPegawai='" + idPegawai + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
