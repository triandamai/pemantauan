package com.tdn.domain.serialize.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.model.JumlahPegawaiModel;

import java.util.List;

public class ResponseGetJumlahPegawai {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<JumlahPegawaiModel> data = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<JumlahPegawaiModel> getData() {
        return data;
    }

    public void setData(List<JumlahPegawaiModel> data) {
        this.data = data;
    }

}
