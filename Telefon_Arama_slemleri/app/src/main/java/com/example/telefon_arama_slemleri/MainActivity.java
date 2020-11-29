package com.example.telefon_arama_slemleri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button ButonArama;
    EditText EditTextPhone;
    //    <uses-permission android:name="android.permission.CALL_PHONE"/> izni ver

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditTextPhone=findViewById(R.id.EditTextPhone);
        ButonArama=findViewById(R.id.ButonArama);
        ButonArama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verial=EditTextPhone.getText().toString();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                //Arama işlemlerimde intente bu paramatre girilir
                intent.setData(Uri.parse("tel:"+verial));
                //Arama işlemleri böyle yapılır
                startActivity(intent);



            }
        });


    }
}