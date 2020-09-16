package com.tdn.domain.serialize.req;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestPostLogin {
    @SerializedName("nrp")
    @Expose
    private String nrp;
    @SerializedName("password")
    @Expose
    private String password;

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RequestPostLogin{" +
                "nrp='" + nrp + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
