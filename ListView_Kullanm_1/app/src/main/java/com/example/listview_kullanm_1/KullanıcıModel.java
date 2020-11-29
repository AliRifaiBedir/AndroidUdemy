package com.example.listview_kullanm_1;

public class KullanıcıModel {
    String isim;
    String soyisim;
    String yas;
    String takım;

    public KullanıcıModel(String isim, String soyisim, String yas, String takım) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.yas = yas;
        this.takım = takım;
    }

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

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String gettakım() {
        return takım;
    }

    public void settakım(String takım) {
        this.takım = takım;
    }
}
