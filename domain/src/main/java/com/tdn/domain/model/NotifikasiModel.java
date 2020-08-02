package com.tdn.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tdn.domain.object.NotifikasiObject;

public class NotifikasiModel extends BaseModel {
    @SerializedName("id_notif")
    @Expose
    private String idNotif;
    @SerializedName("expired_day")
    @Expose
    private Integer expiredDay;
    @SerializedName("expired_date")
    @Expose
    private String expiredDate;
    @SerializedName("stok_obat")
    @Expose
    private String stokObat;
    @SerializedName("stok_minimal")
    @Expose
    private String stokMinimal;
    @SerializedName("obat")
    @Expose
    private String obat;
    @SerializedName("obat_id")
    @Expose
    private String obatId;
    @SerializedName("supplier")
    @Expose
    private String supplier;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;

    public String getIdNotif() {
        return idNotif;
    }

    public void setIdNotif(String idNotif) {
        this.idNotif = idNotif;
    }

    public Integer getExpiredDay() {
        return expiredDay;
    }

    public void setExpiredDay(Integer expiredDay) {
        this.expiredDay = expiredDay;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getStokObat() {
        return stokObat;
    }

    public void setStokObat(String stokObat) {
        this.stokObat = stokObat;
    }

    public String getStokMinimal() {
        return stokMinimal;
    }

    public void setStokMinimal(String stokMinimal) {
        this.stokMinimal = stokMinimal;
    }

    public String getObat() {
        return obat;
    }

    public void setObat(String obat) {
        this.obat = obat;
    }

    public String getObatId() {
        return obatId;
    }

    public void setObatId(String obatId) {
        this.obatId = obatId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NotifikasiModel{" +
                "idNotif='" + idNotif + '\'' +
                ", expiredDay=" + expiredDay +
                ", expiredDate='" + expiredDate + '\'' +
                ", stokObat='" + stokObat + '\'' +
                ", stokMinimal='" + stokMinimal + '\'' +
                ", obat='" + obat + '\'' +
                ", obatId='" + obatId + '\'' +
                ", supplier='" + supplier + '\'' +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public Object ToObject() {
        NotifikasiObject o = new NotifikasiObject();
        o.setIdNotif(idNotif);
        o.setExpiredDate(expiredDate);
        o.setExpiredDay(expiredDay);
        o.setObat(obat);
        o.setObatId(obatId);
        o.setStatus(status);
        o.setStokMinimal(stokMinimal);
        o.setStokObat(stokObat);
        o.setSupplier(supplier);
        o.setMessage(message);
        return o;
    }
}
