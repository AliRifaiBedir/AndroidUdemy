package com.example.realm_grafik_kaytlarnn_arayzde_gsterilmesi_1;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class Tansiyon extends RealmObject {
    private  String  büyükTansiyon;
    private  String  kücükTansiyon;

    public String getBüyükTansiyon() {
        return büyükTansiyon;
    }

    public void setBüyükTansiyon(String büyükTansiyon) {
        this.büyükTansiyon = büyükTansiyon;
    }

    public String getKücükTansiyon() {
        return kücükTansiyon;
    }

    public void setKücükTansiyon(String kücükTansiyon) {
        this.kücükTansiyon = kücükTansiyon;
    }

    @Override
    public String toString() {
        return "Tansiyon{" +
                "büyükTansiyon='" + büyükTansiyon + '\'' +
                ", kücükTansiyon='" + kücükTansiyon + '\'' +
                '}';
    }
}
