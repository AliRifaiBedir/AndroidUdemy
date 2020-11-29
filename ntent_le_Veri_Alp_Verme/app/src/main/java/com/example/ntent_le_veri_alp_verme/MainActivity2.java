package com.example.ntent_le_veri_alp_verme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    String isim, sifre, cinsiyet;
    TextView Adınız,Sifreniz,Cinisiyetiniz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Adınız=findViewById(R.id.Adınız);
        Sifreniz=findViewById(R.id.Sifreniz);
        Cinisiyetiniz=findViewById(R.id.Cinisiyetiniz);



        Bundle intent = getIntent().getExtras();
        isim = (String) intent.get("Kullanıcı Adı");
        sifre = (String) intent.get("Kullanıcı Sifre");
        cinsiyet = (String) intent.get("Kullanıcı Cinsiyet");

        Adınız.setText(Adınız.getText()+" "+isim);
        Sifreniz.setText(Sifreniz.getText()+" "+sifre);
        Cinisiyetiniz.setText(Cinisiyetiniz.getText()+" "+cinsiyet);


    }
}