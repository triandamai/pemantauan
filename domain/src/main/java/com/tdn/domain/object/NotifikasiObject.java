package com.tdn.domain.object;

import com.tdn.domain.model.NotifikasiModel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class NotifikasiObject extends RealmObject {
    @PrimaryKey
    private String idNotif;


    private Integer expiredDay;

    private String expiredDate;

    private String stokObat;

    private String stokMinimal;

    private String obat;

    private String obatId;

    private String supplier;

    private String status;

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
        return "NotifikasiObject{" +
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

    public Object ToModel() {
        NotifikasiModel o = new NotifikasiModel();
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
