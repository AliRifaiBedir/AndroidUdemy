package com.example.realmdatabasekulalnm_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance(); // opens "myrealm.realm"

        tabloyaEkle();
        göster();

    }


    public void tabloyaEkle() {
        realm.beginTransaction();
        //Burdaki amaç transaction ile işleler ya hep ya hiç mottosuyla çalışması için yazıldı.

        KisilerTablosu kisilerTablosu = realm.createObject(KisilerTablosu.class);
        //Nesne olusturma bu şekilde tanımlanmıyor
        kisilerTablosu.setIsim("Ali");
        kisilerTablosu.setSoyisim("Bedir");
        kisilerTablosu.setMaas(300);
        kisilerTablosu.setYas(26);
        realm.commitTransaction();

    }

    public  void göster()
    {
        realm.beginTransaction();

        RealmResults<KisilerTablosu> sonuc=realm.where(KisilerTablosu.class).findAll();
        //Kisiler tablosında olan her kayıdı al
        for(KisilerTablosu k :sonuc){

            Log.i("çıktı",k.toString());
        }


        realm.commitTransaction();


    }



}