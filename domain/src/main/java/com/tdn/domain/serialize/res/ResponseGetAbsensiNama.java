package com.tdn.domain.serialize.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.model.AbsensiNama;

import java.util.List;

public class ResponseGetAbsensiNama {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("nama")
    @Expose
    private List<AbsensiNama> nama = null;

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

    public List<AbsensiNama> getNama() {
        return nama;
    }

    public void setNama(List<AbsensiNama> nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "ResponseGetAbsensiNama{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", nama=" + nama +
                '}';
    }
}
