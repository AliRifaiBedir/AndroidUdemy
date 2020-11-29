package com.example.mail_gnderme_uygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Burdak iişlemleri gerçekleştirince bize aşağıdaki tüm
    //mail uygulamaları açılacak ve hangisini secersek o gönderecek



    EditText EditTextMailİcerik;
    EditText EditTextMailKonu;
    EditText EditTextMailAdres;
    Button Buton;
    Context context = this;

    String icerik, konu, adres;
    //Bunları almak için string bir değişken olusturudk

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditTextMailAdres = findViewById(R.id.EditTextMailAdres);
        EditTextMailİcerik = findViewById(R.id.EditTextMailİcerik);
        EditTextMailKonu = findViewById(R.id.EditTextMailKonu);
        Buton = findViewById(R.id.Buton);


        Buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Butona tıllayınca edittextteki içerikleri aldık
                icerik = EditTextMailİcerik.getText().toString();
                konu = EditTextMailKonu.getText().toString();
                adres = EditTextMailAdres.getText().toString();

                try {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    //Mail Gönderme işlemleri böyler başlar
                    intent.setType("message/rfc822");
                    //Bu sabit değeri girmeyi unutma

                    /* intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"mail1","mail2","..."});
                Eğer birden fazla mail adresi olursa*/
                    intent.putExtra(Intent.EXTRA_EMAIL, adres);

                    intent.putExtra(Intent.EXTRA_SUBJECT, konu);
                    intent.putExtra(Intent.EXTRA_TEXT, icerik);
                    startActivity(Intent.createChooser(intent,"Mail Gönderiniz"));
                    //startActivity böyle tanımlanması gerekiyor göndermek için

                }
                catch (Exception e){
                    Toast.makeText(context,"hata var",Toast.LENGTH_LONG).show();

                }



            }
        });


    }
}