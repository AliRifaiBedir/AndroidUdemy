package com.example.mesaj_gnderme_uygulamas;

public class model {
    private String İsim;
    private  String Tel;

    public String getIsim() {
        return İsim;
    }

    public void setIsim(String isim) {
        İsim = isim;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public model(String isim, String tel) {
        this.İsim = isim;
        this.Tel = tel;
    }
}

