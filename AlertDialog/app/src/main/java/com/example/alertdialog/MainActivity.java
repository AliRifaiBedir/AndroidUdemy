package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Dialog_Ac;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dialog_Ac=findViewById(R.id.Dialog_Ac);
        Dialog_Ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //CustomLayout ulasşmak içinaşağıdaki 2 kodu yazdık
                LayoutInflater inflater=getLayoutInflater();
                View view=inflater.inflate(R.layout.custom_alert_dialog_,null);

                //Layout içindeki viewlere ulastık bu şekilde
                final EditText mailEdittext=view.findViewById(R.id.KullanıcıMail);
                final EditText adiEdittext=view.findViewById(R.id.Kullanıcıİsim);
                final EditText sifreEdittext=view.findViewById(R.id.KullanıcıSifre);
                Button button=view.findViewById(R.id.KayıtOl);


                //AlertDialog gösterim işlemi için bunu yapıyoruz
                AlertDialog.Builder alert=new AlertDialog.Builder(context);
                alert.setView(view);//Görüntülenecek Layout gösterdiik
                alert.setCancelable(false);//Ekranın boşuna tıklayınca kapanmaz

                AlertDialog   dialog=alert.create();//AlertDialog olusturuldu
                dialog.show();




                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,mailEdittext.getText().toString()+""+adiEdittext.getText().toString()+
                                ""+sifreEdittext.getText().toString(),Toast.LENGTH_LONG).show();

                    }
                });






            }
        });








    }
}