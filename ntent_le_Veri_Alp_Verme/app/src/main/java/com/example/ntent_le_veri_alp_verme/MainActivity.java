package com.example.ntent_le_veri_alp_verme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText EditTextKullanıcıAdı;
    EditText EditTextKullanıcıSifre;
    Button Buton;
    RadioGroup RadioGrouop;
    String  ad,sifre,cinsiyet;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        tıklavegec();




    }


    public void tıklavegec(){
        Buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degeral();
                Intent intent=new Intent(context,MainActivity2.class);
                intent.putExtra("Kullanıcı Adı",ad);
                intent.putExtra("Kullanıcı Sifre",sifre);
                intent.putExtra("Kullanıcı Cinsiyet",cinsiyet);
                startActivity(intent);

            }
        });


    }



    public void  degeral(){
        ad=EditTextKullanıcıAdı.getText().toString();
        sifre=EditTextKullanıcıSifre.getText().toString();
        cinsiyet=((RadioButton)(RadioGrouop.findViewById(RadioGrouop.getCheckedRadioButtonId()))).getText().toString();
    }



    public void tanimla() {

        EditTextKullanıcıAdı = findViewById(R.id.EditTextKullanıcıAdı);
        EditTextKullanıcıSifre = findViewById(R.id.EditTextKullanıcıSifre);
        Buton = findViewById(R.id.Buton);
        RadioGrouop = findViewById(R.id.RadioGrouop);

    }


}