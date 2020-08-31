package com.tdn.domain.serialize.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.model.JumlahMasukModel;

import java.util.List;

public class ResponseGetJumlahMasuk {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<JumlahMasukModel> data = null;

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

    public List<JumlahMasukModel> getData() {
        return data;
    }

    public void setData(List<JumlahMasukModel> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseGetJumlahMasuk{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
