package com.example.realmdatabasekulalnm_1;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass//Bunu buraya elle yazmayı unutma
public class KisilerTablosu extends RealmObject {
    private String isim;
    private String soyisim;
    private Integer maas;
    private Integer yas;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public Integer getMaas() {
        return maas;
    }

    public void setMaas(Integer maas) {
        this.maas = maas;
    }

    public Integer getYas() {
        return yas;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }

    @Override
    public String toString() {
        return "KisilerTablosu{" +
                "isim='" + isim + '\'' +
                ", soyisim='" + soyisim + '\'' +
                ", maas=" + maas +
                ", yas=" + yas +
                '}';
    }
}
