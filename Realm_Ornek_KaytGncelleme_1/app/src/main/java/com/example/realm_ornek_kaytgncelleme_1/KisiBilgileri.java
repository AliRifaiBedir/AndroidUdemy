package com.example.realm_ornek_kaytgncelleme_1;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class KisiBilgileri extends RealmObject {
    private  String kullanıcı;
    private  String cinsiyet;
    private  String isim;
    private  String sifre;

    public String getKullanıcı() {
        return kullanıcı;
    }

    public void setKullanıcı(String kullanıcı) {
        this.kullanıcı = kullanıcı;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Override
    public String toString() {
        return "KisiBilgileri{" +
                "kullanıcı='" + kullanıcı + '\'' +
                ", cinsiyet='" + cinsiyet + '\'' +
                ", isim='" + isim + '\'' +
                ", sifre='" + sifre + '\'' +
                '}';
    }
}
